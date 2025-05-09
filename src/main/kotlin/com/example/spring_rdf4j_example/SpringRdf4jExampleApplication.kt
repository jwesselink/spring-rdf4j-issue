package com.example.spring_rdf4j_example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class SpringRdf4jExampleApplication

fun main(args: Array<String>) {
    runApplication<SpringRdf4jExampleApplication>(*args)
}
