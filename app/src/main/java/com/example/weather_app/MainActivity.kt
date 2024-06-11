package com.example.weather_app

import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import com.example.weather_app.databinding.ActivityMainBinding
import com.example.weather_app.utils.RetrofitInstance
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCurrentWeather()

    }

    @OptIn(DelicateCoroutinesApi::class)
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCurrentWeather(){
        GlobalScope.launch(Dispatchers.IO) {
            val response = try {
                RetrofitInstance.api.getCurrentWeather("new york", "metric","")

            }catch (e: IOException){
                Toast.makeText(applicationContext, "app error ${e.message}",Toast.LENGTH_SHORT)
                    .show()
                return@launch


            }catch (e: HttpException){
                Toast.makeText(applicationContext, "Http error${e.message}", Toast.LENGTH_SHORT)
                    .show()
                return@launch

            }

            if (response.isSuccessful && response.body()!= null){

                withContext(Dispatchers.Main){

                    binding.tvTemp.text =" tem: ${response.body()!!.main.temp}"
                }
            }

        }


    }
}
