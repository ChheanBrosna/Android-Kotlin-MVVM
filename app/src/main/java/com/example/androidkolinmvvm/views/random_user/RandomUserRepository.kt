package com.example.androidkolinmvvm.views.random_user

import com.example.androidkolinmvvm.core.services.ApiService
import com.example.androidkolinmvvm.models.RandomUserModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RandomUserRepository(private val apiService: ApiService) {
    suspend fun getRandomUser(): List<RandomUserModel> {
        val response = apiService.getRandomUser();
        val result = response.getAsJsonArray("results")

        val randomUserListType = object: TypeToken<List<RandomUserModel>>() {}.type
        val randomUser: List<RandomUserModel> = Gson().fromJson(result, randomUserListType);
        return randomUser
    }
}