package com.karla.myexamplekotlin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karla.myexamplekotlin.data.database.entities.SuperHeroEntity

@Dao
interface SuperHeroDao {

    @Query("SELECT * FROM superhero_table")
    suspend fun getAllSuperHeroes():List<SuperHeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<SuperHeroEntity>)

    @Query("DELETE FROM superhero_table")
    suspend fun deleteAllSuperHeroes()
}