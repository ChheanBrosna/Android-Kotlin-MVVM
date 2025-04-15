package com.example.androidkolinmvvm.views.random_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RandomUserViewModelFactory(private val randomUserRepository: RandomUserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomUserViewModel::class.java)) {
            return RandomUserViewModel(randomUserRepository) as T
        }

        throw IllegalArgumentException("Invalid view model")
    }
}