package com.karla.myexamplekotlin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karla.myexamplekotlin.data.model.SuperHeroModel
import com.karla.myexamplekotlin.data.model.SuperHeroProvider
import com.karla.myexamplekotlin.domain.GetRandomSuperHeroUserCase
import com.karla.myexamplekotlin.domain.GetSuperHeroesUseCase
import kotlinx.coroutines.launch

class SuperHeroViewModel : ViewModel() {
    var getSuperHeroUseCase = GetSuperHeroesUseCase()
    val superHeroModel = MutableLiveData<com.karla.myexamplekotlin.data.model.Result>()
    val isLoading = MutableLiveData<Boolean>()
    var getRandomSuperHeroUserCase = GetRandomSuperHeroUserCase()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getSuperHeroUseCase()
            if(!result.isNullOrEmpty()){
                superHeroModel.postValue(result[0])
                isLoading.postValue(false)

            }
        }
    }

    fun randomSuperHero(){
        isLoading.postValue(true)
        val superhero = getRandomSuperHeroUserCase()
        if (superhero != null) {
            //superHeroModel.postValue(superhero)
        }
        isLoading.postValue(false)

        /*val currentSuperHero = SuperHeroProvider.random()
        superHeroModel.postValue(currentSuperHero)*/
    }

}