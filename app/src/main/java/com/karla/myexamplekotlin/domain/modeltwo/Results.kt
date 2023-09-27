package com.karla.myexamplekotlin.domain.modeltwo

import com.karla.myexamplekotlin.data.database.entities.SuperHeroEntity
import com.karla.myexamplekotlin.data.model.Data
import com.karla.myexamplekotlin.data.repository.SuperHeroModel

data class Results(val datos: Data)
fun SuperHeroModel.toDomain() = Results(datos)
fun SuperHeroEntity.toDomain() = Results(datos)


