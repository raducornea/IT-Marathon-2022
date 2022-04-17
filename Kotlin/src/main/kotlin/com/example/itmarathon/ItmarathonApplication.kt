package com.example.itmarathon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class ItmarathonApplication

fun main(args: Array<String>) {
	runApplication<ItmarathonApplication>(*args)
}
