package com.karla.myexamplekotlin.data.model

import com.google.gson.annotations.SerializedName

class Data (@SerializedName("results")val results: ArrayList<Result>){
}