package com.aliahmed.forecasting

import com.aliahmed.forecasting.usecase.ForecastingUseCase
import com.aliahmed.forecasting.viewmodel.ForecastingViewModel
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ForecastingViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    // Make sure viewModelScope uses a test dispatcher
    @get:Rule
    val coroutinesDispatcherRule = MainCoroutineDispatcherRule()

    private lateinit var viewModel: ForecastingViewModel
    private lateinit var useCase: ForecastingUseCase

    @Before
    fun setup() {
        useCase = mockk<ForecastingUseCase>()
        viewModel = ForecastingViewModel(useCase)

    }

    @Test
    fun `parseDateToDay() correctly parses a date string into a day name`() {
        // Given
        val dateString = "2023-04-09"
        val expectedDayName = "Sun, 09 Apr"

        // When
        val actualDayName = viewModel.parseDateToDay(dateString)

        // Then
        assertEquals(expectedDayName, actualDayName)
    }

    @Test
    fun `parseDateToDay() returns the original date string if the date string is invalid`() {
        // Given
        val dateString = "Invalid date string"

        // When
        val actualDayName = viewModel.parseDateToDay(dateString)

        // Then
        assertEquals(dateString, actualDayName)
    }
}

@ExperimentalCoroutinesApi
class MainCoroutineDispatcherRule(private val dispatcher: TestDispatcher = StandardTestDispatcher()) :
    TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}