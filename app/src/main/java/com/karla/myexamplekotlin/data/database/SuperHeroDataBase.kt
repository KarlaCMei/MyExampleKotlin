package com.karla.myexamplekotlin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karla.myexamplekotlin.data.database.dao.SuperHeroDao
import com.karla.myexamplekotlin.data.database.entities.SuperHeroEntity

@Database(entities = [SuperHeroEntity:: class], version = 1)
abstract class SuperHeroDataBase: RoomDatabase() {
    abstract fun getSuperHeroDao(): SuperHeroDao

}