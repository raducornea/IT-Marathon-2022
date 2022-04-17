package com.example.itmarathon.models

data class User(
    var id: Int = 0,
    var name: String = "",
    var password: String = "",
    var admin: Int = 0
)