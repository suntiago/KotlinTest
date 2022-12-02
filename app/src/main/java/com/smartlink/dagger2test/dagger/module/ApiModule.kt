package com.smartlink.dagger2test.dagger.module

import com.smartlink.dagger2test.lib.retrofit.RetrofitManager
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
@Singleton
class ApiModule(private val retrofitManager: RetrofitManager) {

    @Singleton
    @Provides
    fun providerRetrofitManager(): RetrofitManager = this.retrofitManager
}