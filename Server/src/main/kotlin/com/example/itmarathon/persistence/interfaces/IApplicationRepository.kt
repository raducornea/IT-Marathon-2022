package com.example.itmarathon.persistence.interfaces

import com.example.itmarathon.models.Application

interface IApplicationRepository {
    fun uploadApp(application: Application): Boolean
    fun updateApp(id: Int, data: String): Boolean
    fun getAppByName(name: String): Application?
    fun getAllApps(): List<Application?>
}