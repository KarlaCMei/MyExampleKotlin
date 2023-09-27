package com.karla.myexamplekotlin.domain

import com.karla.myexamplekotlin.data.SuperHeroRepository
import com.karla.myexamplekotlin.data.database.entities.toDataBase
import com.karla.myexamplekotlin.domain.modeltwo.Results
import javax.inject.Inject

class GetSuperHeroesUseCase @Inject constructor(private val repository: SuperHeroRepository) {
    suspend operator fun invoke():List<Results> {
        val superHero = repository.getAllSuperHeroesFromApi()


        return if(superHero.isNotEmpty()){
            repository.clearSuperHero()
            repository.insertSuperHero(superHero.map { it.toDataBase() })
            superHero
        }else{
            repository.getAllSuperHeroesFromDataBase()
        }

    }

}