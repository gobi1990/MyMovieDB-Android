package com.gobi.mymoviedb.repositoy

import com.gobi.mymoviedb.models.Movie
import com.gobi.mymoviedb.models.MovieListResponse
import com.gobi.mymoviedb.services.MovieApiService
import com.gobi.mymoviedb.services.RetrofitInstance.movieApiService
import com.gobi.mymoviedb.utils.Constants
import retrofit2.Response

class MovieRepository() {

  private val HEADER_ACCESS_TOKEN: String
    get() = "Bearer " + Constants.ACCESS_TOKEN

  suspend fun getNowPlayingMovies(page: Int): Response<MovieListResponse> {
    return movieApiService.getNowPlayingMovies(HEADER_ACCESS_TOKEN , "en-US", page)
  }
}
