package com.gobi.mymoviedb.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

  private val _loginState = MutableStateFlow(LoginState())
  val loginState: StateFlow<LoginState> = _loginState

  fun onEvent(event: LoginEvent) {
    when (event) {
      is LoginEvent.EmailChanged -> {
        _loginState.value = _loginState.value.copy(email = event.email)
      }
      is LoginEvent.PasswordChanged -> {
        _loginState.value = _loginState.value.copy(password = event.password)
      }
      is LoginEvent.Submit -> {
        performLogin()
      }
    }
  }

  private fun performLogin() {
    // Simulate login logic
    viewModelScope.launch {
      _loginState.value = _loginState.value.copy(isLoading = true)

      // Here, you would integrate with a repository or use case
      // to perform actual login operation
      // e.g., val result = loginUseCase(_loginState.value.email, _loginState.value.password)

      // Simulating success or failure
      val success = _loginState.value.email == "user@example.com" && _loginState.value.password == "password"

      if (success) {
        _loginState.value = _loginState.value.copy(isLoginSuccessful = true, isLoading = false)
      } else {
        _loginState.value = _loginState.value.copy(
          errorMessage = "Invalid email or password",
          isLoading = false
        )
      }
    }
  }
}
