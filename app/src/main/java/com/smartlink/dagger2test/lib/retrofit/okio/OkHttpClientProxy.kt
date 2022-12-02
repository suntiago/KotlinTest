package com.smartlink.dagger2test.lib.retrofit.okio

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkHttpClientProxy(val logDebug: Boolean) {
    companion object {
        private const val DEFAULT_TIMEOUT: Long = 10
    }

    private val headersKeyValue: HashMap<String, HashMap<String, String>> = HashMap()
    private fun getHeaders(host: String): HashMap<String, String>? = headersKeyValue[host]

    fun addHeader(host: String, key: String, value: String) {
        getHeaders(host)?.let {
            it[key] = value
        } ?: run {
            headersKeyValue[host] = HashMap()
            addHeader(host, key, value)
        }
    }

    fun defaultOkhttpClient(): OkHttpClient =
        buildOkHttpClient(logDebug, RequestInterceptor())

    private fun buildOkHttpClient(
        isDebug: Boolean,
        vararg interceptors: Interceptor?
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder().apply {
            readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            for (interceptor in interceptors) {
                addInterceptor(interceptor!!)
            }
            if (isDebug) {
                val logInterceptor = HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
                addInterceptor(logInterceptor)
            }
        }
        return okHttpClientBuilder.build()
    }

    private inner class RequestInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest: Request = chain.request()
            val build: Request.Builder = originalRequest.newBuilder()
            val host = originalRequest.url.host;
            getHeaders(host)?.let { map ->
                for ((k, v) in map) {
                    build.header(k, v)
                }
            }
            return build.build().let { chain.proceed(it) }
        }
    }
}