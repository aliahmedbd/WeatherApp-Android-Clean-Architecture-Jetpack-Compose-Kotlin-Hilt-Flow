package com.aliahmed.data.network

import com.aliahmed.data.model.BaseApiResponse
import com.aliahmed.data.model.CurrentWeather
import retrofit2.http.GET

interface ApiService {

    @GET("current.json")
    suspend fun getCurrentWeather() : Result<CurrentWeather>

}