package com.aliahmed.current_weather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.size.Scale
import com.aliahmed.core_ui.ErrorDialog
import com.aliahmed.core_ui.FullScreenLoading
import com.aliahmed.core_ui.R
import com.aliahmed.current_weather.viewmodel.CurrentWeatherViewModel
import com.aliahmed.data.model.CurrentWeather
import com.aliahmed.data.model.Hour
import com.aliahmed.data.network.Resource
import java.time.LocalDate

@Composable
fun CurrentWeatherScreen(
    navController: NavController,
    viewModel: CurrentWeatherViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getCurrentWeather()
    }

    val state by viewModel.state.collectAsState()

    var currentWeatherSate by remember {
        mutableStateOf(CurrentWeather())
    }

    when (val pageState = state) {
        is Resource.Loading -> {
            FullScreenLoading()
        }
        is Resource.Error -> {
            ErrorDialog(message = pageState.message, {})
        }

        is Resource.Success -> {
            currentWeatherSate = pageState.data as CurrentWeather
        }
        else -> {}
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {

            Spacer(modifier = Modifier.height(16.dp))

            HeaderWeather(currentWeatherSate)

            currentWeatherSate.forecast?.forecastday?.get(0)?.hour?.let {
                HourlyForecasting(
                    it,
                    viewModel
                )
            }

        }
    }
}

@Composable
fun HeaderWeather(
    currentWeather: CurrentWeather
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            contentDescription = "Weather icon",
            model = "https:${currentWeather.current?.condition?.icon}",
            placeholder = painterResource(
                id = R.drawable.current_weather
            ),
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        )
        Text(
            text = currentWeather.current?.condition?.text ?: "Loading...",
            modifier = Modifier,
            style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 32.0.sp,
                        fontWeight = FontWeight(700.0.toInt()),
                        fontStyle = FontStyle.Normal,
                    )
                ) {
                    append("${currentWeather.current?.tempC ?: "..."} ")
                }
                withStyle(
                    style = SpanStyle(
                        baselineShift = BaselineShift.Superscript,
                        fontSize = 8.0.sp,
                        fontWeight = FontWeight(300.0.toInt()),
                        fontStyle = FontStyle.Normal,
                    )
                ) { // AnnotatedString.Builder
                    append(" o")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 32.0.sp,
                        fontWeight = FontWeight(300.0.toInt()),
                        fontStyle = FontStyle.Normal,
                    )
                ) {
                    append("C")
                }
            },
            modifier = Modifier,
            style = TextStyle(fontSize = 32.sp, color = MaterialTheme.colors.onBackground),
        )

        Row {
            SubItems(
                title = "Humidity",
                value = "${currentWeather.current?.humidity ?: ".."}%",
            )
            Spacer(modifier = Modifier.width(8.dp))
            SubItems(
                title = "UV",
                value = (currentWeather.current?.uv ?: "..").toString()
            )
            Spacer(modifier = Modifier.width(8.dp))
            SubItems(
                title = "Feels Like",
                value = (currentWeather.current?.feelslikeC ?: "...").toString()
            )
        }
    }
}


@Composable
fun SubItems(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground)
        )
    }
}


@Composable
fun HourlyForecasting(hours: List<Hour>, viewModel: CurrentWeatherViewModel) {

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Hourly Status",
            style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow() {
            items(hours, itemContent = {
                hourItem(
                    time = viewModel.parseDateToTime(it.time),
                    icon = "https:${it.condition.icon}",
                    temp = it.tempC.toString()
                )

                Spacer(modifier = Modifier.width(8.dp))

            })
        }
    }

}

@Composable
fun hourItem(
    time: String,
    icon: String,
    temp: String
) {
    Card {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 16.0.sp,
                            fontWeight = FontWeight(700.0.toInt()),
                            fontStyle = FontStyle.Normal,
                        )
                    ) {
                        append(temp)
                    }
                    withStyle(
                        style = SpanStyle(
                            baselineShift = BaselineShift.Superscript,
                            fontSize = 8.0.sp,
                            fontWeight = FontWeight(300.0.toInt()),
                            fontStyle = FontStyle.Normal,
                        )
                    ) { // AnnotatedString.Builder
                        append(" o")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 16.0.sp,
                            fontWeight = FontWeight(300.0.toInt()),
                            fontStyle = FontStyle.Normal,
                        )
                    ) {
                        append("C")
                    }
                },
                modifier = Modifier,
                style = TextStyle(fontSize = 32.sp, color = MaterialTheme.colors.onBackground),
            )

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                contentDescription = "Weather icon",
                model = icon,
                placeholder = painterResource(
                    id = R.drawable.current_weather
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )

            Text(
                text = time,
                style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onBackground)
            )

        }
    }
}


@Preview
@Composable
fun CurrentWeatherPreview() {
//    CurrentWeatherScreen()
}