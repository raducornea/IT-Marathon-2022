package com.example.itmarathon.persistence.mappers

import com.example.itmarathon.models.Device
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class DeviceRowMapper:RowMapper<Device?> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Device {
        return Device(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("user_id")
        )
    }
}