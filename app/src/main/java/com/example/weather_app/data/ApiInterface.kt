package com.example.weather_app.data

import com.example.weather_app.data.models.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather?")
    suspend fun getCurrentWeather(

        @Query("q")city :String,
        @Query("units")units :String,
        @Query("appid")apikey :String

    ): Response<CurrentWeather>
}