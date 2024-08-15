package com.gobi.mymoviedb.views.screens.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gobi.mymoviedb.repositoy.MovieRepository
import com.gobi.mymoviedb.views.viewmodels.MovieViewModel

class HomeViewModelFactory(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
      return HomeViewModel(movieRepository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}
