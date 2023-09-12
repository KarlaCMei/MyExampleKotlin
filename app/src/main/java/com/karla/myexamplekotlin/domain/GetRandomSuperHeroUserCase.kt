package com.karla.myexamplekotlin.domain

import com.karla.myexamplekotlin.data.SuperHeroRepository
import com.karla.myexamplekotlin.data.model.SuperHeroModel
import com.karla.myexamplekotlin.data.model.SuperHeroProvider

class GetRandomSuperHeroUserCase {

    operator fun invoke():SuperHeroModel?{
        val quotes = SuperHeroProvider.superHero
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}