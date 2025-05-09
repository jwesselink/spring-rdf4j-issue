package com.example.spring_rdf4j_example

import org.eclipse.rdf4j.repository.Repository
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository
import org.eclipse.rdf4j.spring.RDF4JConfig
import org.eclipse.rdf4j.spring.pool.PoolConfig
import org.eclipse.rdf4j.spring.tx.TxConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(RDF4JConfig::class, TxConfig::class, PoolConfig::class)
class RDF4JConfiguration {
    @Bean
    fun repository(@Value("\${rdf4j.spring.repository.remote.manager-url}") endpoint: String): Repository =
        SPARQLRepository(endpoint)

}