package com.example.weather_app.data

import retrofit2.http.GET

interface ApiInterface {

    @GET("weather")
    suspend fun getCurrentWeather()
}