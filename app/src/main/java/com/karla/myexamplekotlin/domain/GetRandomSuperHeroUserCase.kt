package com.karla.myexamplekotlin.domain

import com.karla.myexamplekotlin.data.SuperHeroRepository
import com.karla.myexamplekotlin.data.model.SuperHeroProvider
import com.karla.myexamplekotlin.domain.modeltwo.Results
import javax.inject.Inject

class GetRandomSuperHeroUserCase @Inject constructor(private val repository: SuperHeroRepository) {

    suspend operator fun invoke():Results?{
        val quotes = repository.getAllSuperHeroesFromDataBase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}