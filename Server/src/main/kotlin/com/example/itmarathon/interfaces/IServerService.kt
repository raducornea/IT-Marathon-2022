package com.example.itmarathon.interfaces

import com.example.itmarathon.models.Application
import com.example.itmarathon.models.Device
import com.example.itmarathon.models.User

interface IServerService {

    fun getAllApplications(): List<Application?>

    fun registerNewUser(userName: String, password: String): Boolean
    fun registerNewDevice(deviceName: String, userId: Int): Boolean
    fun defineApplication(name: String, data: String): Boolean

    fun getDeviceApplications(deviceId: Int): List<Application?>
    fun getUserDevices(userId: Int): List<Device?>

    fun notifyUpdates(deviceId: Int, application: Application)
    fun notifyDeletion(deviceId: Int, application: Application)

    fun uploadVersionSoftwareFiles(name: String, information: String): Boolean
    fun deleteApplication(id: Int, name: String, information: String, version: Int)

    fun getApplicationByName(name: String): Application?
    fun loginUser(userName: String, password: String): User?
}