package com.smartlink.dagger2test.ui.main

import android.util.Log
import com.google.gson.Gson
import com.smartlink.dagger2test.lib.retrofit.RetrofitManager
import com.smartlink.dagger2test.ui.Api

class UserRemoteDateSource constructor(private val retrofitManager: RetrofitManager) {
    companion object {
        private const val TAG = "UserRemoteDateSource"
    }

    fun getWeather() {
        retrofitManager.createApi(Api::class.java)?.let {
            it.getWeather(mapOf("11" to "南京"))
                .subscribe({ next ->
                    Log.d(TAG, "init: [next] ${Gson().toJson(next)}")
                }, { error -> Log.d(TAG, "init: [error] $error") },
                    { Log.d(TAG, "init: [complete]") })
        }
    }
}