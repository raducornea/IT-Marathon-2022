package com.example.itmarathon.persistence.interfaces

import com.example.itmarathon.models.User

interface IUserRepository {
    fun registerUser(user: User): Boolean
    fun loginUser(name: String, password: String): User?
}