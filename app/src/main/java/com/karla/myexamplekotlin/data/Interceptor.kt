package com.karla.myexamplekotlin.data

import android.content.res.Configuration
import okhttp3.Interceptor
import okhttp3.Response

class Interceptor: Interceptor {

    private val APIKEY_NAME = "apikey"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val originalHttpUrl = request.url()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(APIKEY_NAME, "658791e59fd52e517abe2e09f27b9c17")
            .addQueryParameter("ts", "1")
            .addQueryParameter("hash", "3d60d3b8d2c2b56ed6d0c03d504ba2c2")
            .build()

        val newRequest = request.newBuilder().url(url).build()

        return chain.proceed(newRequest)
    }

}