package com.karla.myexamplekotlin.data.network

import com.karla.myexamplekotlin.core.RetrofitHelper
import com.karla.myexamplekotlin.data.model.SuperHeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SuperHeroService{

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<com.karla.myexamplekotlin.data.model.Result> {
        return withContext(Dispatchers.Main) {
            val response = retrofit.create(SuperHeroApiClient::class.java).getAllSuperHeroes()
            response.body()!!.datos.results ?: emptyList()
        }
    }
}