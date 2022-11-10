package com.smartlink.dagger2test.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ApiModule
 *
 * @author zaiyu
 * @description:
 * @date :2022/5/13 14:56
 */
@Module
class ApiModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApi(): Application = this.application
}