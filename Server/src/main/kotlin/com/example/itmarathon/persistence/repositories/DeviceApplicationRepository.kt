package com.example.itmarathon.persistence.repositories

import com.example.itmarathon.models.Application
import com.example.itmarathon.models.Device
import com.example.itmarathon.persistence.interfaces.IDevicesApplicationsRepository
import com.example.itmarathon.persistence.mappers.ApplicationRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.UncategorizedSQLException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.DriverManager.println


@Repository
class DeviceApplicationRepository: IDevicesApplicationsRepository {

    @Autowired
    private lateinit var _jdbcTemplate: JdbcTemplate

    private var _appRowMapper: RowMapper<Application?> = ApplicationRowMapper()

    override fun installApplicationOnDevice(device: Device, application: Application): Boolean {
        createTable()
        try {
            _jdbcTemplate.update("INSERT INTO Devices_Applications(device_id, application_id) " +
                    "VALUES(?, ?)", device.id, application.id)
            return true
        }
        catch (e: UncategorizedSQLException)
        {
            println("Error while trying to install app on device")
        }
        return false
    }

    override fun getApplicationsOfDevice(deviceId: Int): List<Application?> {
        return _jdbcTemplate.query("SELECT a.id, a.name, a.data, a.version " +
                "FROM Devices d, Applications a, Devices_Applications da " +
                "WHERE da.device_id == d.id AND da.application_id == a.id " +
                "AND d.id = $deviceId", _appRowMapper)
    }

    private fun createTable() {
        _jdbcTemplate.update("""CREATE TABLE IF NOT EXISTS "Devices_Applications" (
                                    "id"	INTEGER,
                                    "device_id"	INTEGER,
                                    "application_id"	INTEGER,
                                    FOREIGN KEY("application_id") REFERENCES "Applications"("id"),
                                    PRIMARY KEY("id" AUTOINCREMENT),
                                    FOREIGN KEY("device_id") REFERENCES "Devices"("id"))""")
    }
}