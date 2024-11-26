// FootballApi.kt
package com.example.goaltrack.core.services

import com.example.goaltrack.core.data.League
import retrofit2.http.GET

interface FootballApi {

    @GET("competitions")
    suspend fun getLeagues(): List<League>
}
