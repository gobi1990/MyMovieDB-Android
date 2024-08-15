package com.gobi.mymoviedb.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gobi.mymoviedb.repositoy.MovieRepository

class MovieViewModelFactory(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
      return MovieViewModel(movieRepository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}
