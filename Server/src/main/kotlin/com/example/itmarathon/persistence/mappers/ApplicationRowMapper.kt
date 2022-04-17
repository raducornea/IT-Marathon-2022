package com.example.itmarathon.persistence.mappers

import com.example.itmarathon.models.Application
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class ApplicationRowMapper: RowMapper<Application?> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Application {
        return Application(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("version"),
            rs.getString("data")
        )
    }
}