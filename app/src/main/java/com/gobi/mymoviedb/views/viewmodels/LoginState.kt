package com.gobi.mymoviedb.views.viewmodels

data class LoginState(
  val email: String = "",
  val password: String = "",
  val isLoading: Boolean = false,
  val isLoginSuccessful: Boolean = false,
  val errorMessage: String? = null
)

sealed class LoginEvent {
  data class EmailChanged(val email: String) : LoginEvent()
  data class PasswordChanged(val password: String) : LoginEvent()
  object Submit : LoginEvent()
}
