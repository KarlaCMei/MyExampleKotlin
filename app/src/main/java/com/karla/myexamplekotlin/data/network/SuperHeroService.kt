package com.karla.myexamplekotlin.data.network

import com.karla.myexamplekotlin.data.repository.SuperHeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SuperHeroService @Inject constructor(private val api: SuperHeroApiClient){

    suspend fun getSuperHero(): List<SuperHeroModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllSuperHeroes()
            response.body() ?: emptyList()
        }
    }
}