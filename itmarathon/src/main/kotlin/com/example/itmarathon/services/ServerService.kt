package com.example.itmarathon.services

import org.springframework.stereotype.Service

@Service
class ServerService {
    fun registerNewUser(userName: String, password: String){

    }

    fun registerNewDevice(deviceName: String){

    }

    fun defineApplication(id: Int, name: String, information: String, version: Int){

    }

    /** In functie de deviceId, se va notifica user-ul cu privire la noi versiuni pe care le poate sau nu updata */
    fun notifyUpdates(deviceId: Int){

    }

    /** Vine un nou update */
    fun uploadVersionSoftwareFiles(id: Int, name: String, information: String, version: Int){
        /** Trebuie notificati utilizatorii care folosesc acea aplicatie */
    }

    /** Se sterge o Aplicatie cu totul */
    fun deleteApplication(id: Int, name: String, information: String, version: Int){
        /** Trebuie notificati utilizatorii care folosesc acea aplicatie */
    }
}