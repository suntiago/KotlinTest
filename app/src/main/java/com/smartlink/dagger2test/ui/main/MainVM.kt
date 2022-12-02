package com.smartlink.dagger2test.ui.main

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.smartlink.dagger2test.lib.retrofit.RetrofitManager
import javax.inject.Inject

/**
 * MainVM
 *
 * @author zaiyu
 * @description:
 * @date :2022/4/29 16:05
 */
class MainVM @Inject constructor(
    private val application: Application,
    private var retrofitManager: RetrofitManager
) {
    private val TAG = "MainVM"
    private var weatherRepository: WeatherRepository = WeatherRepository(
        LocalWeatherDateSource(),
        UserRemoteDateSource(retrofitManager)
    )

    fun init() {

        Toast.makeText(application, "test dagger2", Toast.LENGTH_LONG).show();
        Log.d(TAG, "init: ")
        weatherRepository.getWeather()
    }
}
