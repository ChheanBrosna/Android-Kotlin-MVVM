package com.example.androidkolinmvvm.core.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val baseUrl = "https://randomuser.me/";
    private val _apiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
    val apiService: ApiService get() = _apiService;
}