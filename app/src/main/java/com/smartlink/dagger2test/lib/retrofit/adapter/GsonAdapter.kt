package com.smartlink.dagger2test.lib.retrofit.adapter

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.smartlink.dagger2test.lib.retrofit.adapter.gsondefault.IntegerDefault0Adapter
import com.smartlink.dagger2test.lib.retrofit.adapter.gsondefault.DoubleDefault0Adapter
import com.smartlink.dagger2test.lib.retrofit.adapter.gsondefault.LongDefault0Adapter

object GsonAdapter {
    fun buildGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Int::class.java, IntegerDefault0Adapter())
            .registerTypeAdapter(Int::class.javaPrimitiveType, IntegerDefault0Adapter())
            .registerTypeAdapter(Double::class.java, DoubleDefault0Adapter())
            .registerTypeAdapter(Double::class.javaPrimitiveType, DoubleDefault0Adapter())
            .registerTypeAdapter(Long::class.java, LongDefault0Adapter())
            .registerTypeAdapter(Long::class.javaPrimitiveType, LongDefault0Adapter())
            .create()
    }
}