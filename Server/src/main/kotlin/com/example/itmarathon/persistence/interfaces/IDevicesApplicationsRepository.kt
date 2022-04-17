package com.example.itmarathon.persistence.interfaces

import com.example.itmarathon.models.Application
import com.example.itmarathon.models.Device

interface IDevicesApplicationsRepository {
    fun installApplicationOnDevice(device: Device, application: Application): Boolean
    fun getApplicationsOfDevice(deviceId: Int): List<Application?>
}