package com.example.itmarathon.interfaces

import com.example.itmarathon.models.Application
import com.example.itmarathon.models.Device

interface IServerService {
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
}