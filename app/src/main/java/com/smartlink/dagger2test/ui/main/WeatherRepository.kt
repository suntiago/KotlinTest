package com.smartlink.dagger2test.ui.main

class WeatherRepository (
    private val localWeatherDateSource: LocalWeatherDateSource,
    private val userRemoteDateSource: UserRemoteDateSource
) {
    fun getWeather() {
        userRemoteDateSource.getWeather()
    }
}