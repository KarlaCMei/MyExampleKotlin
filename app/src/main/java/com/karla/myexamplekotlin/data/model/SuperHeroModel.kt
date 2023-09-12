package com.karla.myexamplekotlin.data.model

import com.google.gson.annotations.SerializedName

class SuperHeroModel(@SerializedName("image")val image: String, @SerializedName("name") val name: String){
}