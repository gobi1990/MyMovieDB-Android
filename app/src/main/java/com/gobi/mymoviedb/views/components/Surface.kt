package com.gobi.mymoviedb.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.gobi.mymoviedb.ui.theme.LightBlue
import com.gobi.mymoviedb.ui.theme.MyMovieDBTheme
import kotlin.math.ln

/**
 * An alternative to [androidx.compose.material.Surface] utilizing
 * [com.example.jetsnack.ui.theme.JetsnackColors]
 */
@Composable
fun MysnackSurface(
  modifier: Modifier = Modifier,
  shape: Shape = RectangleShape,
  color: Color = MaterialTheme.colorScheme.error,
  contentColor: Color = MaterialTheme.colorScheme.secondary,
  border: BorderStroke? = null,
  elevation: Dp = 0.dp,
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier.shadow(elevation = elevation, shape = shape, clip = false)
      .zIndex(elevation.value)
      .then(if (border != null) Modifier.border(border, shape) else Modifier)
      .background(
        color = getBackgroundColorForElevation(color, elevation),
        shape = shape
      )
      .clip(shape)
  ) {
    CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
  }
}

@Composable
private fun getBackgroundColorForElevation(color: Color, elevation: Dp): Color {
  return if (elevation > 0.dp // && https://issuetracker.google.com/issues/161429530
  // JetsnackTheme.colors.isDark //&&
  // color == JetsnackTheme.colors.uiBackground
  ) {
    color.withElevation(elevation)
  } else {
    color
  }
}

/**
 * Applies a [Color.White] overlay to this color based on the [elevation]. This increases visibility
 * of elevation for surfaces in a dark theme.
 *
 * TODO: Remove when public https://issuetracker.google.com/155181601
 */
private fun Color.withElevation(elevation: Dp): Color {
  val foreground = calculateForeground(elevation)
  return foreground.compositeOver(this)
}
private fun calculateForeground(elevation: Dp): Color {
  val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
  return Color.White.copy(alpha = alpha)
}

@Composable
fun SimpleSurface(buttonText : String) {
  Surface(
    modifier = Modifier.padding(16.dp),
    color = LightBlue,
    shape = RoundedCornerShape(8.dp),
    shadowElevation = 5.dp
  ) {
    Text(
      text = buttonText,
      modifier = Modifier.padding(16.dp),
      color = Color.White
    )
  }
}

@Preview
@Composable
private fun RectangleButtonPreview() {
  SimpleSurface( buttonText = "Click Me")
}

