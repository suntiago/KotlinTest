package com.smartlink.dagger2test.dagger.module

import android.app.Application
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LayoutModule(private var layoutInflater: LayoutInflater) {
    @Provides
    fun provideLayoutInflater(): LayoutInflater = this.layoutInflater
}