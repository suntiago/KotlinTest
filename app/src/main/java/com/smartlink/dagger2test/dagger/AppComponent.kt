package com.smartlink.dagger2test.dagger

import com.smartlink.dagger2test.dagger.module.*
import com.smartlink.dagger2test.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class, LayoutModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}