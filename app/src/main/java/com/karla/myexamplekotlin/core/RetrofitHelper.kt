package com.karla.myexamplekotlin.core

import com.karla.myexamplekotlin.data.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val BASE_URL: String = "https://gateway.marvel.com:443/"

    fun getRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder().addInterceptor(Interceptor()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()


    }
}