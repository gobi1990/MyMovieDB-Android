package com.gobi.mymoviedb.views.screens.Home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gobi.mymoviedb.repositoy.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

  private val _state = mutableStateOf(HomeState())
  val state: State<HomeState> = _state

  init {
      getNowPlayingMovies(_state.value.page)
  }

  fun getNowPlayingMovies(page: Int) {
    viewModelScope.launch {
      try {
        _state.value = _state.value.copy(isLoading = true)
        val response = movieRepository.getNowPlayingMovies(state.value.page)

        if (response.isSuccessful && response.body() != null) {
          _state.value = _state.value.copy(
            movies = response.body()!!.results,
            isLoading = false
          )
        } else {
            _state.value = _state.value.copy(
              error = "Failed to load movies!",
              isLoading = false
            )
        }
      } catch (e: Exception) {
        _state.value = _state.value.copy(
          error = e.message ?: "An unexpected error occurred",
          isLoading = false
        )
      }
    }
  }

//  private fun getNowPlayingMovies()
//  {
//
//  }
}
