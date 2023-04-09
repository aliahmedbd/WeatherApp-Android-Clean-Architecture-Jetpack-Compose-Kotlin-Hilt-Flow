package com.aliahmed.data.model


import com.google.gson.annotations.SerializedName

data class CurrentWeather (
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location
)