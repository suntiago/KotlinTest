package com.smartlink.dagger2test

import android.app.Application
import android.view.LayoutInflater
import com.smartlink.dagger2test.dagger.AppComponent
import com.smartlink.dagger2test.dagger.DaggerAppComponent
import com.smartlink.dagger2test.dagger.module.ApiModule
import com.smartlink.dagger2test.dagger.module.ApplicationModule
import com.smartlink.dagger2test.dagger.module.LayoutModule
import com.smartlink.dagger2test.lib.retrofit.RetrofitManager
import com.smartlink.dagger2test.lib.retrofit.okio.OkHttpClientProxy
import com.smartlink.dagger2test.ui.main.LocalWeatherDateSource
import com.smartlink.dagger2test.ui.main.UserRemoteDateSource
import com.smartlink.dagger2test.ui.main.WeatherRepository

open class MainApplication : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        createCompponent()
    }

    private fun createCompponent() {
        val apiModule = ApiModule(RetrofitManager(OkHttpClientProxy(true),
            """https://uat-iov-ec.fawjiefang.com.cn/app/api/faw/rest-businesss/"""))
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this@MainApplication))
            .apiModule(apiModule)
            .layoutModule(LayoutModule(LayoutInflater.from(this@MainApplication)))
            .build()
    }
}