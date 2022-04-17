package com.example.itmarathon.services

import com.example.itmarathon.interfaces.IServerService
import org.springframework.stereotype.Service

@Service
class ServerService : IServerService {
    override fun registerNewUser(userName: String, password: String){

    }

    override fun registerNewDevice(deviceName: String){

    }

    override fun defineApplication(id: Int, name: String, information: String, version: Int){

    }

    /** In functie de deviceId, se va notifica user-ul cu privire la noi versiuni pe care le poate sau nu updata */
    override fun notifyUpdates(deviceId: Int, application: Application){

    }

    override fun notifyDeletion(deviceId: Int, application: Application){

    }

    /** Vine un nou update */
    override fun uploadVersionSoftwareFiles(id: Int, name: String, information: String, version: Int){
        /** Trebuie notificati utilizatorii care folosesc acea aplicatie */
    }

    /** Se sterge o Aplicatie cu totul */
    override fun deleteApplication(id: Int, name: String, information: String, version: Int){
        /** Trebuie notificati utilizatorii care folosesc acea aplicatie */
    }
}