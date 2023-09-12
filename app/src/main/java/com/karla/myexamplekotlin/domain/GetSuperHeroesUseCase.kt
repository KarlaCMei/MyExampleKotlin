package com.karla.myexamplekotlin.domain

import com.karla.myexamplekotlin.data.SuperHeroRepository
import com.karla.myexamplekotlin.data.model.SuperHeroModel

class GetSuperHeroesUseCase {
    private val repository = SuperHeroRepository()
    suspend operator fun invoke():List<SuperHeroModel>? = repository.getAllSuperHeroes()

}