package com.smartlink.dagger2test.dagger

import android.os.Parcel
import android.os.Parcelable
import com.smartlink.dagger2test.MainActivity
import com.smartlink.dagger2test.dagger.module.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent{
//    fun inject(activity: MainActivity)
}