package com.karla.myexamplekotlin.data

import com.karla.myexamplekotlin.data.model.SuperHeroModel
import com.karla.myexamplekotlin.data.model.SuperHeroProvider
import com.karla.myexamplekotlin.data.network.SuperHeroService

class SuperHeroRepository {

    private val api = SuperHeroService()
    suspend fun getAllSuperHeroes():List<com.karla.myexamplekotlin.data.model.Result>{
        val response = api.getQuotes()
        SuperHeroProvider.superHero = response
        return response
    }
}