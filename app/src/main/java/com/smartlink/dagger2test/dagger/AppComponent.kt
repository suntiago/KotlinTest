package com.smartlink.dagger2test.dagger

import com.smartlink.dagger2test.MainActivity
import com.smartlink.dagger2test.dagger.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}