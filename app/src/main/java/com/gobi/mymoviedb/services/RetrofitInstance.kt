package com.gobi.mymoviedb.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

  private const val BASE_URL = "https://api.themoviedb.org/3/"

  private val retrofitClient: Retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val movieApiService: MovieApiService by lazy {
    retrofitClient.create(MovieApiService::class.java)
  }
}
