package com.aliahmed.data.network

import com.aliahmed.data.model.BaseApiResponse
import com.aliahmed.data.model.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast.json")
    suspend fun getCurrentWeather(
        @Query("key") key: String = BaseURL.apiKey,
        @Query("q") location: String = "London",
        @Query("days") days: String = "1",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no",
    ): Result<CurrentWeather>

}