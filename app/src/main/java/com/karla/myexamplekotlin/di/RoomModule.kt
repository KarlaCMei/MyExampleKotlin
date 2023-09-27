package com.karla.myexamplekotlin.di

import android.content.Context
import androidx.room.Room
import com.karla.myexamplekotlin.data.database.SuperHeroDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object RoomModule {

    private const val QUOTE_DATA_BASE_NAME = "superhero_database"

    @Singleton
    @Provides
    fun providersRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, SuperHeroDataBase:: class.java, QUOTE_DATA_BASE_NAME).build()

    @Singleton
    @Provides
    fun providersQuoteDao(db : SuperHeroDataBase ) = db.getSuperHeroDao()
}