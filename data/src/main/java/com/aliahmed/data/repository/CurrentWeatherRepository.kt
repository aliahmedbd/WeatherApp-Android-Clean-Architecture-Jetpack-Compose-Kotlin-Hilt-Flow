package com.aliahmed.data.repository

import com.aliahmed.data.model.CurrentWeather
import com.aliahmed.data.network.ApiService
import javax.inject.Inject

interface CurrentWeatherRepository  {
    suspend fun getCurrentWeather() : Result<CurrentWeather>
}

class CurrentWeatherRepositoryImpl @Inject constructor(private val apiService: ApiService) : CurrentWeatherRepository {

    override suspend fun getCurrentWeather(): Result<CurrentWeather> {
        return apiService.getCurrentWeather()
    }

}