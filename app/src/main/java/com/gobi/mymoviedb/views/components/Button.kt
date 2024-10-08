package com.gobi.mymoviedb.views.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.gobi.mymoviedb.ui.theme.LightBlue
import com.gobi.mymoviedb.ui.theme.LightBlue3
import com.gobi.mymoviedb.ui.theme.MyMovieDBTheme

@Composable
fun DefaultButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  shape: Shape = ButtonShape,
  border: BorderStroke? = null,
  backgroundGradient: Color = MaterialTheme.colorScheme.background,
  disabledBackgroundGradient: Color = MaterialTheme.colorScheme.onSecondary,
  contentColor: Color = MaterialTheme.colorScheme.background,
  disabledContentColor: Color = MaterialTheme.colorScheme.error,
  contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
  content: @Composable RowScope.() -> Unit
) {
  MysnackSurface(
    shape = shape,
    color = Color.Transparent,
    contentColor = if (enabled) contentColor else disabledContentColor,
    border = border,
    modifier = modifier
      .clip(shape)
      .background(
        brush = Brush.linearGradient(
          colors = listOf(LightBlue, LightBlue3)
        )
      )
      .clickable(
        onClick = onClick,
        enabled = enabled,
        role = Role.Button,
        interactionSource = interactionSource,
        indication = null
      )
  ) {
    ProvideTextStyle(
      value = MaterialTheme.typography.labelMedium
    ) {
      Row(
        Modifier
          .defaultMinSize(
            minWidth = ButtonDefaults.MinWidth,
            minHeight = ButtonDefaults.MinHeight
          )
          .indication(interactionSource, rememberRipple())
          .padding(contentPadding),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = content
      )
    }
  }
}

private val ButtonShape = RoundedCornerShape(percent = 50)

//@Preview("default", "round")
//@Preview("dark theme", "round", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font", "round", fontScale = 2f)
@Composable
private fun ButtonPreview() {
  MyMovieDBTheme {
    DefaultButton(onClick = {}) {
      Text(text = "Demo")
    }
  }
}



@Composable
fun LinearGradientExample() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(
        brush = Brush.linearGradient(
          colors = listOf(LightBlue, LightBlue3)
        )
      )
  )
}


@Preview("default", "rectangle")
//@Preview("dark theme", "rectangle", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font", "rectangle", fontScale = 2f)
@Composable
private fun RectangleButtonPreview() {
  MyMovieDBTheme {
//    DefaultButton(
//      onClick = {}, shape = RoundedCornerShape(percent = 50)
//    ) {
//      Text(text = "Demo")
//    }
    LinearGradientExample()
  }
}
