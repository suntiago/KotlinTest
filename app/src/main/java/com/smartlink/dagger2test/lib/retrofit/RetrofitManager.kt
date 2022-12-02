package com.smartlink.dagger2test.lib.retrofit


import com.smartlink.dagger2test.lib.retrofit.adapter.GsonAdapter
import com.smartlink.dagger2test.lib.retrofit.okio.OkHttpClientProxy
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager(
    private val okHttpClientProxy: OkHttpClientProxy,
    private val defaultHost: String,
    private var callAdapterFactory: Array<CallAdapter.Factory>? = null,
    private var converterFactory: Array<Converter.Factory>? = null
) {
    private val apiObjects: HashMap<String, HashMap<Class<*>, Any>> = HashMap()
    private fun <T> getApiObjects(host: String, tClass: Class<T>): T? =
        apiObjects[host]?.get(tClass) as T

    private fun <T> addApiObjects(host: String, tClass: Class<T>, o: Any) {
        if (apiObjects.containsKey(host)) {
            apiObjects[host]?.also {
                if (it.containsKey(tClass)) {
                    it.remove(tClass)
                }
                it[tClass] = o
            }
        } else {
            apiObjects[host] = HashMap()
            addApiObjects(host, tClass, o)
        }
    }

    @Synchronized
    fun <T> createApi(tClass: Class<T>): T? {
        val host = defaultHost
        val t: T? = getApiObjects(host, tClass)
        if (t == null) {
            build().create(tClass)?.let {
                addApiObjects(host, tClass, it)
            }
        }
        return getApiObjects(host, tClass)
    }


    @Synchronized
    fun <T> createApi(tClass: Class<T>, baseUrl: String?): T? = baseUrl?.let { host ->
        val t: T? = getApiObjects(host, tClass)
        if (t == null) {
            build().create(tClass)?.let {
                addApiObjects(host, tClass, it)
            }
        }
        return getApiObjects(host, tClass)
    }

    private fun build(): Retrofit = Retrofit.Builder().apply {
        baseUrl(defaultHost)
        callAdapterFactory?.let {
            for (factory in it) {
                addCallAdapterFactory(factory)
            }
        } ?: run {
            // add default CallAdapter.Factory
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        }
        converterFactory?.let {
            for (factory in it) {
                addConverterFactory(factory)
            }
        } ?: run {
            //add default Converter.Factory
            addConverterFactory(GsonConverterFactory.create(GsonAdapter.buildGson()))
        }
        client(okHttpClientProxy.defaultOkhttpClient())
    }.build()
}