package com.smartlink.dagger2test.ui

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @Headers("Content-Type: application/json")
    @POST("vehicle/request/weather/query")
    fun getWeather(@Body requestBody: Map<String, String>): Observable<Any>
}