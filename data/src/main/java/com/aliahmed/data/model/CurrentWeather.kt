package com.aliahmed.data.model


import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("current")
    val current: Current? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("forecast")
    val forecast: Forecast? = null
)