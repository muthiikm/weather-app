package com.example.weather_app

import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCurrentWeather()

    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCurrentWeather(){
        GlobalScope.launch(Dispatchers.IO) {
            val response = try {

            }catch (e: IOException){
                Toast.makeText(applicationContext, "app error ${e.message}",Toast.LENGTH_SHORT).show()


            }catch (e: HttpException){
                Toast.makeText(applicationContext, "Http error${e.message}", Toast.LENGTH_SHORT).show()

            }
        }


    }
}
