package com.example.itmarathon.interfaces

import com.example.itmarathon.models.Application

interface IServerService {
    fun registerNewUser(userName: String, password: String): Boolean
    fun registerNewDevice(deviceName: String, userId: Int): Boolean
    fun defineApplication(name: String, data: String): Boolean
    fun notifyUpdates(deviceId: Int, application: Application)
    fun notifyDeletion(deviceId: Int, application: Application)
    fun uploadVersionSoftwareFiles(id: Int, name: String, information: String, version: Int)
    fun deleteApplication(id: Int, name: String, information: String, version: Int)
}