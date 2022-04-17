package com.example.itmarathon.persistence.interfaces

import com.example.itmarathon.models.Device
import com.example.itmarathon.models.User

interface IDeviceRepository {
    fun registerDevice(device: Device): Boolean
    fun getDevicesOfUser(userId: Int): List<Device?>
}