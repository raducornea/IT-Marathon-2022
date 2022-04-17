package com.example.itmarathon.controllers

import com.example.itmarathon.interfaces.IServerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ApplicationController {
    @Autowired
    private lateinit var _serverService: IServerService

    @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
    fun registerNewUser(@RequestBody user: User): ResponseEntity<Unit> {
        _serverService.registerNewUser(user)
        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/device"], method = [RequestMethod.POST])
    fun registerNewDevice(@RequestBody device: Device): ResponseEntity<Unit> {
        _serverService.registerNewDevice(device)
        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/application"], method = [RequestMethod.POST])
    fun defineApplication(@RequestBody application: Application): ResponseEntity<Unit> {
        _serverService.registerNewDevice(application)
        return ResponseEntity(Unit, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/application/{id}"], method = [RequestMethod.PUT])
    fun updateSoftwareVersion(@PathVariable id: Int, @RequestBody application: Application): ResponseEntity<Unit> {
        _serverService.getApplication(id)?.let {
            _serverService.notifyUpdates(it.id, application)
            return ResponseEntity(Unit, HttpStatus.ACCEPTED)
        } ?: return ResponseEntity(Unit, HttpStatus.NOT_FOUND)
    }

    @RequestMapping(value = ["/application/{id}"], method = [RequestMethod.DELETE])
    fun deletePerson(@PathVariable id: Int, @RequestBody application: Application): ResponseEntity<Unit> {
        if (_serverService.getApplication(id) != null) {
            _serverService.notifyDeletion(it.id, application)
            return ResponseEntity(Unit, HttpStatus.OK)
        } else {
            return ResponseEntity(Unit, HttpStatus.NOT_FOUND)
        }
    }

}