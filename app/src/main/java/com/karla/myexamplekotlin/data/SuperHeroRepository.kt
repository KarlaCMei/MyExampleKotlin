package com.karla.myexamplekotlin.data

import com.karla.myexamplekotlin.data.database.dao.SuperHeroDao
import com.karla.myexamplekotlin.data.database.entities.SuperHeroEntity
import com.karla.myexamplekotlin.data.network.SuperHeroService
import com.karla.myexamplekotlin.data.repository.SuperHeroModel
import com.karla.myexamplekotlin.domain.modeltwo.Results
import com.karla.myexamplekotlin.domain.modeltwo.toDomain
import javax.inject.Inject

class SuperHeroRepository @Inject constructor(
    private val api: SuperHeroService,
    private val superHeroDao: SuperHeroDao
) {

    suspend fun getAllSuperHeroesFromApi(): List<Results> {
        val response: List<SuperHeroModel> = api.getSuperHero()
        return response.map { it.toDomain() }
    }

    suspend fun getAllSuperHeroesFromDataBase(): List<Results> {
        val response: List<SuperHeroEntity> = superHeroDao.getAllSuperHeroes()
        return response.map { it.toDomain() }
    }

    suspend fun insertSuperHero(quotes: List<SuperHeroEntity>){
        superHeroDao.insertAll(quotes)
    }

    suspend fun clearSuperHero(){
        superHeroDao.deleteAllSuperHeroes()
    }
}