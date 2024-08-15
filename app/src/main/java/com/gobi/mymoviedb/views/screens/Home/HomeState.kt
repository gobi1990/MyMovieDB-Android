package com.gobi.mymoviedb.views.screens.Home

import com.gobi.mymoviedb.models.Movie
import com.gobi.mymoviedb.utils.Strings

data class HomeState(
  val isLoading: Boolean = false,
  val movies: List<Movie> = emptyList(),
  val error: String = "",
  val page: Int = 1
)
