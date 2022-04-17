package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication()
open class ItmarathonApplication

fun main(args: Array<String>) {
    runApplication<ItmarathonApplication>(*args)
}
