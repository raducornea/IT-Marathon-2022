package com.example.itmarathon.persistence.repositories

import com.example.itmarathon.models.Application
import com.example.itmarathon.persistence.interfaces.IApplicationRepository
import com.example.itmarathon.persistence.mappers.ApplicationRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.UncategorizedSQLException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.DriverManager.println


@Repository
class ApplicationRepository: IApplicationRepository {

    @Autowired
    private lateinit var _jdbcTemplate: JdbcTemplate

    private var _rowMapper: RowMapper<Application?> = ApplicationRowMapper()

    override fun uploadApp(application: Application): Boolean {
        createTable()
        try {
            _jdbcTemplate.update("INSERT INTO Applications(name, version, data) " +
                    "VALUES(?, ?, ?)", application.name, application.version, application.data)
            return true
        }
        catch (e: UncategorizedSQLException)
        {
            println("An error has occurred while trying to upload app")
        }
        return false
    }

    override fun updateApp(id: Int, data: String): Boolean {
        try {
            _jdbcTemplate.update("UPDATE Applications SET data = ?, version = version + 1 " +
                    "WHERE id = ?", data, id)
            return true
        }
        catch (e: UncategorizedSQLException)
        {
            println("Error while updating app")
        }
        return false
    }

    override fun getAppByName(name: String): Application? {
        return _jdbcTemplate.queryForObject("SELECT * FROM Applications WHERE name = '$name'", _rowMapper)
    }

    override fun getAllApps(): List<Application?> {
        return _jdbcTemplate.query("SELECT * FROM Applications", _rowMapper)
    }

    private fun createTable() {
        _jdbcTemplate.execute("""CREATE TABLE IF NOT EXISTS "Applications" (
                                    "id"	INTEGER,
                                    "name"	TEXT NOT NULL UNIQUE,
                                    "version"	INTEGER NOT NULL,
                                    "data"	TEXT NOT NULL,
                                    PRIMARY KEY("id" AUTOINCREMENT))""")
    }
}