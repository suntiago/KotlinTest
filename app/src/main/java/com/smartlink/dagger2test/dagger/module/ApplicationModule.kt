package com.smartlink.dagger2test.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ApplicationModule
 *
 * @author zaiyu
 * @description:
 * @date :2022/4/28 15:20
 */
@Module
class ApplicationModule(private val application: Application)  {
    @Provides
    @Singleton
    fun provideContext(): Application = this.application
}