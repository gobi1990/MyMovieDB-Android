package com.gobi.mymoviedb.views.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gobi.mymoviedb.R
import com.gobi.mymoviedb.ui.theme.LightBlue2
import com.gobi.mymoviedb.ui.theme.Pink40
import com.gobi.mymoviedb.ui.theme.Purple40
import com.gobi.mymoviedb.ui.theme.Purple80
import com.gobi.mymoviedb.ui.theme.PurpleGrey40
import com.gobi.mymoviedb.views.viewmodels.AuthViewModel
import com.gobi.mymoviedb.views.viewmodels.LoginEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: AuthViewModel) {
  val loginState by viewModel.loginState.collectAsState()

  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Icon(
        Icons.Outlined.Send,
        contentDescription = stringResource(id = R.string.app_name),
        tint= Purple40,
        modifier = Modifier.width(100.dp).height(100.dp)
      )
      Text(
        text = "MY MOVIE DB",
        style = TextStyle(
          brush = Brush.linearGradient(
            colors = listOf(Color.Cyan
              , LightBlue2 , Purple40)
          )
        ),
        fontSize = 30.sp,
        modifier = Modifier.padding(bottom = 32.dp)
      )

      if (loginState.errorMessage != null) {
        Text(
          text = loginState.errorMessage ?: "",
          color = MaterialTheme.colorScheme.error,
          style = MaterialTheme.typography.headlineMedium,
          modifier = Modifier.padding(bottom = 8.dp)
        )
      }

      OutlinedTextField(
        value = loginState.email,
        onValueChange = { viewModel.onEvent(LoginEvent.EmailChanged(it)) },
        label = { Text("Email") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
          imeAction = ImeAction.Next
        )
      )

      Spacer(modifier = Modifier.height(16.dp))

      OutlinedTextField(
        value = loginState.password,
        onValueChange = { viewModel.onEvent(LoginEvent.PasswordChanged(it)) },
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
          imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
          onDone = { viewModel.onEvent(LoginEvent.Submit) }
        )
      )

      Spacer(modifier = Modifier.height(32.dp))

      Button(
        onClick = { viewModel.onEvent(LoginEvent.Submit) },
        enabled = !loginState.isLoading,
        modifier = Modifier.fillMaxWidth()
      ) {
        if (loginState.isLoading) {
          CircularProgressIndicator(
            color = Color.White,
            modifier = Modifier.size(24.dp)
          )
        } else {
          Text(text = "Login")
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      TextButton(
        onClick = { /* Navigate to Forgot Password Screen */ },
        modifier = Modifier.align(Alignment.End)
      ) {
        Text(text = "Forgot Password?")
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
  LoginScreen(viewModel = AuthViewModel())
}
