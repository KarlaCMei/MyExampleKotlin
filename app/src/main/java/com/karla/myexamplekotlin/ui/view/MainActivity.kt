package com.karla.myexamplekotlin.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.karla.myexamplekotlin.R
import com.karla.myexamplekotlin.databinding.ActivityMainBinding
import com.karla.myexamplekotlin.ui.viewmodel.SuperHeroViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val superHeroViewModel: SuperHeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        superHeroViewModel.onCreate()

        superHeroViewModel.superHeroModel.observe(this, Observer { currentSuperHero ->
            Glide.with(this).load(currentSuperHero.image).into(binding.imgSuperHero)
            binding.txtSuperHeroName.text = currentSuperHero.name
        })
        superHeroViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
        binding.viewContainer.setOnClickListener {
            superHeroViewModel.randomSuperHero() }

    }
}