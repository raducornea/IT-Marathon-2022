package com.example.itmarathon.services

import com.example.itmarathon.interfaces.IServerService
import com.example.itmarathon.models.Application
import com.example.itmarathon.models.Device
import com.example.itmarathon.models.User
import com.example.itmarathon.persistence.interfaces.IApplicationRepository
import com.example.itmarathon.persistence.interfaces.IDeviceRepository
import com.example.itmarathon.persistence.interfaces.IDevicesApplicationsRepository
import com.example.itmarathon.persistence.interfaces.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ServerService : IServerService {

    @Autowired
    private lateinit var _applicationRepository: IApplicationRepository

    @Autowired
    private lateinit var _userRepository: IUserRepository

    @Autowired
    private lateinit var _deviceRepository: IDeviceRepository

    @Autowired
    private lateinit var _devicesApplicationsRepository: IDevicesApplicationsRepository


    override fun getAllApplications(): List<Application?> {
        return _applicationRepository.getAllApps()
    }

    override fun registerNewUser(userName: String, password: String): Boolean {
        return _userRepository.registerUser(User(name = userName, password = password, admin = 0))
    }

    override fun registerNewDevice(deviceName: String, userId: Int): Boolean{
        return _deviceRepository.registerDevice(Device(name = deviceName, userId = userId));
    }

    override fun defineApplication(name: String, data: String): Boolean{
        return _applicationRepository.uploadApp(Application(name = name, data = data))
    }

    override fun getDeviceApplications(deviceId: Int): List<Application?> {
        return _devicesApplicationsRepository.getApplicationsOfDevice(deviceId)
    }

    override fun getUserDevices(userId: Int): List<Device?> {
        return _deviceRepository.getDevicesOfUser(userId)
    }


    /** In functie de deviceId, se va notifica user-ul cu privire la noi versiuni pe care le poate sau nu updata */
    override fun notifyUpdates(deviceId: Int, application: Application){

    }

    override fun notifyDeletion(deviceId: Int, application: Application){

    }

    /** Vine un nou update */
    override fun uploadVersionSoftwareFiles(name: String, information: String): Boolean{
        /** Trebuie notificati utilizatorii care folosesc acea aplicatie */
        val app = _applicationRepository.getAppByName(name)
        if (app != null) {
            _applicationRepository.updateApp(app.id, information)
            return true
        }
        return false
    }

    /** Se sterge o Aplicatie cu totul */
    override fun deleteApplication(id: Int, name: String, information: String, version: Int){
        /** Trebuie notificati utilizatorii care folosesc acea aplicatie */
    }

    override fun getApplicationByName(name: String): Application? {
        return _applicationRepository.getAppByName(name)
    }

    override fun loginUser(userName: String, password: String): User? {
        return _userRepository.loginUser(userName, password)
    }
}