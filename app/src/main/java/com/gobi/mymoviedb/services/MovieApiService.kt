package com.gobi.mymoviedb.services

import com.gobi.mymoviedb.models.Movie
import com.gobi.mymoviedb.models.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApiService {

  @GET("/movie/now_playing")
  suspend fun getNowPlayingMovies(
    @Header("Authorization") accessToken: String,
    @Query("language") language: String,
    @Query("page") page: Int
  ): Response<List<Movie>>
}
