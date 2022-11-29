package com.smartlink.dagger2test

import android.app.Application
import android.view.LayoutInflater
import com.smartlink.dagger2test.dagger.AppComponent
import com.smartlink.dagger2test.dagger.DaggerAppComponent
import com.smartlink.dagger2test.dagger.module.ApiModule
import com.smartlink.dagger2test.dagger.module.ApplicationModule
import com.smartlink.dagger2test.dagger.module.LayoutModule

open class MainApplication : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        createCompponent()
    }

    private fun createCompponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this@MainApplication))
            .apiModule(ApiModule("1234"))
            .layoutModule(LayoutModule(LayoutInflater.from(this@MainApplication)))
            .build()
    }
}