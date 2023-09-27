package com.karla.myexamplekotlin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karla.myexamplekotlin.domain.GetRandomSuperHeroUserCase
import com.karla.myexamplekotlin.domain.GetSuperHeroesUseCase
import com.karla.myexamplekotlin.domain.modeltwo.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperHeroViewModel @Inject constructor(
    private val getSuperHeroUseCase:GetSuperHeroesUseCase,
    private val getRandomSuperHeroUserCase:GetRandomSuperHeroUserCase): ViewModel() {
    val superHeroModel = MutableLiveData<Results>()
    val isLoading = MutableLiveData<Boolean>()


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
        viewModelScope.launch {
            isLoading.postValue(true)
            val superhero = getRandomSuperHeroUserCase()

            if (superhero != null) {
                superHeroModel.postValue(superhero)
            }
            isLoading.postValue(false)
        }
        /*val currentSuperHero = SuperHeroProvider.random()
        superHeroModel.postValue(currentSuperHero)*/
    }

}