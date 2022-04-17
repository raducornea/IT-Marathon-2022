package com.example.itmarathon.interfaces

interface IServerService {
    fun registerNewUser(userName: String, password: String)
    fun registerNewDevice(deviceName: String)
    fun defineApplication(id: Int, name: String, information: String, version: Int)
    fun notifyUpdates(deviceId: Int, application: Application)
    fun notifyDeletion(deviceId: Int, application: Application)
    fun uploadVersionSoftwareFiles(id: Int, name: String, information: String, version: Int)
    fun deleteApplication(id: Int, name: String, information: String, version: Int)
}