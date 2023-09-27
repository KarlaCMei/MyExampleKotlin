package com.karla.myexamplekotlin.data.repository

import com.google.gson.annotations.SerializedName
import com.karla.myexamplekotlin.data.model.Data

class SuperHeroModel(@SerializedName("data")val datos: Data){
}