package com.example.itmarathon.persistence.repositories

import com.example.itmarathon.models.User
import com.example.itmarathon.persistence.interfaces.IUserRepository
import com.example.itmarathon.persistence.mappers.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.UncategorizedSQLException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.DriverManager.println


@Repository
class UserRepository: IUserRepository {

    @Autowired
    private lateinit var _jdbcTemplate: JdbcTemplate

    private var _rowMapper: RowMapper<User?>  = UserRowMapper()

    override fun registerUser(user: User): Boolean {
        createTable()
        try {
            _jdbcTemplate.update("INSERT INTO Users(name, password, admin) " +
                    "VALUES(?, ?, ?)", user.name, user.password, user.admin)
            return true
        }
        catch (e: UncategorizedSQLException)
        {
            println("An error has occurred while trying to register user")
        }
        return false
    }

    override fun loginUser(name: String, password: String): User? {
        return try {
            _jdbcTemplate.queryForObject(
                "SELECT * FROM Users WHERE name = '$name' AND password = '$password'", _rowMapper)
        } catch (e: Exception) {
            null
        }
    }

    private fun createTable() {
        _jdbcTemplate.execute("""CREATE TABLE IF NOT EXISTS Users (
                                    id INTEGER,
                                    name TEXT NOT NULL UNIQUE,
                                    password TEXT NOT NULL,
                                    admin INTEGER NOT NULL,
                                    PRIMARY KEY(id AUTOINCREMENT))""")
    }

}