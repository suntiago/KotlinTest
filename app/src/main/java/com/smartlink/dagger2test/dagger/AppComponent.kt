package com.smartlink.dagger2test.dagger

import com.smartlink.dagger2test.MainActivity
import com.smartlink.dagger2test.dagger.module.ApiModule
import com.smartlink.dagger2test.dagger.module.ApplicationModule
import com.smartlink.dagger2test.dagger.module.LayoutModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class, LayoutModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}