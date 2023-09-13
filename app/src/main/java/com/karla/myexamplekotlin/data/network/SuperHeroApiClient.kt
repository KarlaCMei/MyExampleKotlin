package com.karla.myexamplekotlin.data.network

import com.karla.myexamplekotlin.data.model.SuperHeroModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SuperHeroApiClient {
    //https://gateway.marvel.com/v1/public/characters?ts=9&apikey=8db8300b9cdbfd0198bf2253477cfcac&hash=1207b76d3476e1a96bced1f13a1f12af&offset=0&limit=2&nameStartsWith=spider
    @GET("/v1/public/characters?ts=1&apikey=658791e59fd52e517abe2e09f27b9c17&hash=3d60d3b8d2c2b56ed6d0c03d504ba2c2")
   suspend fun getAllSuperHeroes(): Response<SuperHeroModel>

    //suspend fun getAllSuperHeroes(): Call<SuperHeroModel?>?
    //fun getAllSuperHeroes(): Call<SuperHeroModel?>?

}