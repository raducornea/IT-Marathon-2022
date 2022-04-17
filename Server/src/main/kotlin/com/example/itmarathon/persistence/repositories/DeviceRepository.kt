package com.example.itmarathon.persistence.repositories

import com.example.itmarathon.models.Device
import com.example.itmarathon.models.User
import com.example.itmarathon.persistence.interfaces.IDeviceRepository
import com.example.itmarathon.persistence.mappers.DeviceRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.UncategorizedSQLException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.DriverManager.println


@Repository
class DeviceRepository: IDeviceRepository {

    @Autowired
    private lateinit var _jdbcTemplate: JdbcTemplate

    private var _rowMapper: RowMapper<Device?> = DeviceRowMapper()

    override fun registerDevice(device: Device): Boolean {
        createTable()
        try {
            _jdbcTemplate.update("INSERT INTO Devices(name, user_id) " +
                    "VALUES(?, ?)", device.name, device.userId)
            return true
        }
        catch (e: UncategorizedSQLException) {
            println("Error while trying to register device")
        }
        return false
    }

    override fun getDevicesOfUser(userId: Int): List<Device?> {
        return _jdbcTemplate.query("SELECT * FROM Devices WHERE user_id = ${userId}", _rowMapper)
    }

    private fun createTable() {
        _jdbcTemplate.update("""CREATE TABLE IF NOT EXISTS "Devices" (
                                    "id"	INTEGER,
                                    "name"	TEXT NOT NULL,
                                    "user_id"	INTEGER,
                                    FOREIGN KEY("user_id") REFERENCES "Users"("id"),
                                    CONSTRAINT "DEVICES_NAME_USER_ID_UK" UNIQUE("name","user_id"),
                                    PRIMARY KEY("id" AUTOINCREMENT))""")
    }
}