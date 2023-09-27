package com.karla.myexamplekotlin.di
import com.karla.myexamplekotlin.data.Interceptor
import com.karla.myexamplekotlin.data.network.SuperHeroApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        val httpClient = OkHttpClient.Builder().addInterceptor(Interceptor()).build()
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providerSuperHeroApiClient(retrofit: Retrofit):SuperHeroApiClient{
        return retrofit.create(SuperHeroApiClient::class.java)
    }
}