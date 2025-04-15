package com.example.androidkolinmvvm.models

data class RandomUserModel(
    var gender: String,
    var name: NameModel
)

data class NameModel(
    var title: String,
    var first: String,
    var last: String
)