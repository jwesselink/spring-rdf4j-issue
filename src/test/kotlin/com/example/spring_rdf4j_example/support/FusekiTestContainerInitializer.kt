package com.example.spring_rdf4j_example.support

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName

class FusekiTestContainerInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    class FusekiContainer(imageName: DockerImageName) : GenericContainer<FusekiContainer>(imageName)

    companion object {
        private val fusekiImage = DockerImageName.parse("secoresearch/fuseki")
        private val fusekiContainer = FusekiContainer(fusekiImage)
            .withEnv("ENABLE_DATA_WRITE", "true")
            .withEnv("ENABLE_UPDATE", "true")
            .withExposedPorts(3030)
            .waitingFor(Wait.forHttp("/$/ping").forStatusCode(200))
    }

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        fusekiContainer.start()
        TestPropertyValues.of(
            "rdf4j.spring.repository.remote.manager-url=http://${fusekiContainer.host}:${fusekiContainer.firstMappedPort}/ds/update"
        ).applyTo(applicationContext.environment)
    }
}