package com.aliahmed.current_weather.usecase

import com.aliahmed.data.model.CurrentWeather
import com.aliahmed.data.repository.CurrentWeatherRepository
import javax.inject.Inject

class CurrentWeatherUseCase @Inject constructor(private val repositories : CurrentWeatherRepository) {
    suspend fun getCurrentWeather() : Result<CurrentWeather> = repositories.getCurrentWeather()

}