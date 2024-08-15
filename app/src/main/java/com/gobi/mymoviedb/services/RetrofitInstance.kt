package com.gobi.mymoviedb.services

import com.gobi.mymoviedb.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

  private val retrofitClient: Retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(Constants.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val movieApiService: MovieApiService by lazy {
    retrofitClient.create(MovieApiService::class.java)
  }
}
