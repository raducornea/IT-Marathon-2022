package com.example.itmarathon.controllers

import com.example.itmarathon.interfaces.IServerService
import com.example.itmarathon.models.Application
import com.example.itmarathon.models.ApplicationUpdate
import com.example.itmarathon.models.Device
import com.example.itmarathon.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ApplicationController {
    @Autowired
    private lateinit var _serverService: IServerService

    @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
    fun registerNewUser(@RequestParam(required = true, name = "userName") userName : String,
                        @RequestParam(required = true, name = "password") password : String): ResponseEntity<Unit> {
        val status = _serverService.registerNewUser(userName, password)

        return if (status) ResponseEntity(Unit, HttpStatus.CREATED)
        else ResponseEntity(Unit, HttpStatus.BAD_REQUEST)
    }

    @RequestMapping(value = ["/device"], method = [RequestMethod.POST])
    fun registerNewDevice(@RequestParam(required = true, name = "deviceName") deviceName : String,
                          @RequestParam(required = true, name = "userId") userId : Int): ResponseEntity<Unit> {
        val status = _serverService.registerNewDevice(deviceName, userId)

        return if (status) ResponseEntity(Unit, HttpStatus.CREATED)
        else ResponseEntity(Unit, HttpStatus.BAD_REQUEST)
    }

    @RequestMapping(value = ["/application"], method = [RequestMethod.POST])
    fun defineApplication(@RequestParam(required = true, name = "name") name : String,
                          @RequestParam(required = true, name = "data") data : String): ResponseEntity<Unit> {
        val status = _serverService.defineApplication(name, data)

        return if (status) ResponseEntity(Unit, HttpStatus.CREATED)
        else ResponseEntity(Unit, HttpStatus.BAD_REQUEST)
    }

    // applicationModel - JSON care contine name si information
    @RequestMapping(value = ["/application"], method = [RequestMethod.PUT])
    fun uploadVersionSoftwareFiles(@RequestBody applicationModel: ApplicationUpdate): ResponseEntity<Unit> {
        val status = _serverService.uploadVersionSoftwareFiles(applicationModel.name, applicationModel.data)

        return if (status) ResponseEntity(Unit, HttpStatus.CREATED)
        else ResponseEntity(Unit, HttpStatus.NOT_FOUND)
    }

    //todo
//    @RequestMapping(value = ["/application"], method = [RequestMethod.DELETE])
//    fun deleteApplication(@PathVariable id: Int, @RequestBody application: Application): ResponseEntity<Unit> {
//        if (_serverService.getApplication(id) != null) {
//            _serverService.notifyDeletion(id, application)
//            return ResponseEntity(Unit, HttpStatus.OK)
//        } else {
//            return ResponseEntity(Unit, HttpStatus.NOT_FOUND)
//        }
//    }
}