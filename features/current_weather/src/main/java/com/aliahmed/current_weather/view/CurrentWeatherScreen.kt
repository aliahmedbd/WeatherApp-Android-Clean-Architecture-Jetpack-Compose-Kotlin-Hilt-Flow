package com.aliahmed.current_weather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliahmed.core_ui.R

@Composable
fun CurrentWeatherScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {

            Spacer(modifier = Modifier.height(16.dp))

            HeaderWeather()
        }
    }
}

@Composable
fun HeaderWeather() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.current_weather),
            contentDescription = "Weather icon"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "36 C", modifier = Modifier, style = TextStyle(fontSize = 32.sp, color = MaterialTheme.colors.onBackground))
    }
}


@Preview
@Composable
fun CurrentWeatherPreview() {
    CurrentWeatherScreen()
}