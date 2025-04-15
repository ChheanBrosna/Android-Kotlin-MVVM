package com.example.androidkolinmvvm.core.services

import com.example.androidkolinmvvm.models.RandomUserModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api")
    suspend fun getRandomUser(): JsonObject
}

