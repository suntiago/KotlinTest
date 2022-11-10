package com.smartlink.dagger2test

import android.app.Application
import com.smartlink.dagger2test.dagger.AppComponent
import com.smartlink.dagger2test.dagger.module.ApplicationModule
import com.smartlink.dagger2test.dagger.DaggerAppComponent

open class MainApplication : Application() {
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        createCompponent()
    }

    private fun createCompponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

    }
}