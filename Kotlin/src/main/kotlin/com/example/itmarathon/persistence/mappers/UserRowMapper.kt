package com.example.itmarathon.persistence.mappers

import com.example.itmarathon.models.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class UserRowMapper: RowMapper<User?> {
    override fun mapRow(rs: ResultSet, rowNum: Int): User {
        return User(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getInt("admin")
        )
    }
}