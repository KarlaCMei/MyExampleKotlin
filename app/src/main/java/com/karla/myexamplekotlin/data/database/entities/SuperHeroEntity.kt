package com.karla.myexamplekotlin.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.karla.myexamplekotlin.data.model.Data
import com.karla.myexamplekotlin.domain.modeltwo.Results

@Entity(tableName = "superhero_table")
data class SuperHeroEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "data") val datos: Data
    )

fun Results.toDataBase() = SuperHeroEntity(datos = datos)
