package com.aliahmed.current_weather

import com.aliahmed.current_weather.usecase.CurrentWeatherUseCase
import com.aliahmed.current_weather.viewmodel.CurrentWeatherViewModel
import com.aliahmed.data.model.CurrentWeather
import com.aliahmed.data.network.Resource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.text.Typography.times

class CurrentWeatherViewModelTest {

    private lateinit var viewModel: CurrentWeatherViewModel
    private lateinit var currentWeatherUseCase: CurrentWeatherUseCase

    @Before
    fun setup() {
        currentWeatherUseCase = mockk<CurrentWeatherUseCase>()
        viewModel = CurrentWeatherViewModel(currentWeatherUseCase)
    }

    @Test
    fun `parseDateToTime() correctly parses a date string into a time string`() {
        // Given
        val dateString = "2023-04-09 12:00"
        val expectedTimeString = "12:00 am"

        // When
        val actualTimeString = viewModel.parseDateToTime(dateString)

        // Then
        assertEquals(expectedTimeString, actualTimeString)
    }

    @Test
    fun `parseDateToTime() returns the original date string if the date string is invalid`() {
        // Given
        val dateString = "Invalid date string"

        // When
        val actualTimeString = viewModel.parseDateToTime(dateString)

        // Then
        assertEquals(dateString, actualTimeString)
    }


}