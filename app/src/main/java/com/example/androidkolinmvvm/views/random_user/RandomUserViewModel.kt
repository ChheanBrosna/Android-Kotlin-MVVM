package com.example.androidkolinmvvm.views.random_user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkolinmvvm.models.RandomUserModel
import kotlinx.coroutines.launch

class RandomUserViewModel(private val randomUserRepository: RandomUserRepository) : ViewModel() {
    private var _randomUserLiveData = MutableLiveData<List<RandomUserModel>>()
    val randomUserLiveData: MutableLiveData<List<RandomUserModel>> get() = _randomUserLiveData;

    private var _isLoading = MutableLiveData<Boolean>(false);
    val isLoading: MutableLiveData<Boolean> get() = _isLoading

    fun getRandomUser() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val result = randomUserRepository.getRandomUser()
                _randomUserLiveData.value = result
            } catch (e: Exception) {
                println("Exception: $e")
            } finally {
                isLoading.value = false;
            }
        }
    }
 }