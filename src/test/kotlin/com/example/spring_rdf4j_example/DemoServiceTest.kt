package com.example.spring_rdf4j_example

import com.example.spring_rdf4j_example.support.IntegrationTest
import org.assertj.core.api.Assertions.assertThat
import org.eclipse.rdf4j.http.client.SharedHttpClientSessionManager
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.ConcurrentHashMap

@IntegrationTest
class DemoServiceTest {

    @Autowired
    private lateinit var service: DemoService

    @Autowired
    private lateinit var repository: SPARQLRepository

    @Test
    fun `invoke service and expect all the connections to be closed`() {
        service.invoke()

        val openSessions = ((repository.httpClientSessionManager) as SharedHttpClientSessionManager).getOpenSessions()
        println("There are ${openSessions.size} open sessions")
        assertThat(openSessions.size).isEqualTo(0)
    }
}

// This is a workaround to access the private field `openSessions` in the `SharedHttpClientSessionManager` class, to demonstrate the memory leak issue.
fun SharedHttpClientSessionManager.getOpenSessions(): ConcurrentHashMap<SharedHttpClientSessionManager, Boolean> {
    val loadedClass = SharedHttpClientSessionManager::class
    val valueField = loadedClass.java.getDeclaredField("openSessions")
    valueField.isAccessible = true
    return valueField.get(this) as ConcurrentHashMap<SharedHttpClientSessionManager, Boolean>
}