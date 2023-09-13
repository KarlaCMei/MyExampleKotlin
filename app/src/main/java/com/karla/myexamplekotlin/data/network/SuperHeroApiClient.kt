package com.karla.myexamplekotlin.data.network

import com.karla.myexamplekotlin.data.model.SuperHeroModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SuperHeroApiClient {
    //https://gateway.marvel.com/v1/public/characters?ts=9&apikey=8db8300b9cdbfd0198bf2253477cfcac&hash=1207b76d3476e1a96bced1f13a1f12af&offset=0&limit=2&nameStartsWith=spider
    @GET("/v1/public/characters")
   suspend fun getAllSuperHeroes(): Response<SuperHeroModel>

}