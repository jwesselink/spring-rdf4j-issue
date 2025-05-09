package com.example.spring_rdf4j_example.support

import com.example.spring_rdf4j_example.SpringRdf4jExampleApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(
    classes = [SpringRdf4jExampleApplication::class],
)
@ContextConfiguration(
    initializers = [
        FusekiTestContainerInitializer::class,
    ]
)
@ActiveProfiles("test")
annotation class IntegrationTest
