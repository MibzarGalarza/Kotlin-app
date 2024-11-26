// ApiService.kt
package com.example.goaltrack.core.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL = "https://api.football-data.org/v2/"

    val api: FootballApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballApi::class.java)
    }
}
