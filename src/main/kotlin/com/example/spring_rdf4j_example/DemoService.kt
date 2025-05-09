package com.example.spring_rdf4j_example

import com.example.spring_rdf4j_example.rdf.PK
import com.example.spring_rdf4j_example.rdf.RDA
import com.example.spring_rdf4j_example.rdf.RDF
import com.example.spring_rdf4j_example.rdf.update
import org.eclipse.rdf4j.model.util.Values.literal
import org.eclipse.rdf4j.sparqlbuilder.core.query.Queries.INSERT
import org.eclipse.rdf4j.sparqlbuilder.graphpattern.GraphPatterns.tp
import org.eclipse.rdf4j.sparqlbuilder.graphpattern.TriplePattern
import org.eclipse.rdf4j.spring.support.RDF4JTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class DemoService(
    private val rdf4jTemplate: RDF4JTemplate
) {

    fun saveAll() {
        for (i in 1..500) {
            rdf4jTemplate.applyToConnection { it.clear() }
            saveDemo(UUID.randomUUID(), "Demo $i")
        }
    }

    private fun saveDemo(id: UUID, title: String) {
        val iri = PK.production(id)
        insertTriples(
            tp(iri, RDF.type, RDA.Classes.work),
            tp(iri, RDF.type, RDA.Classes.expression),
            tp(iri, RDA.Work.hasTitleOfWork, literal(title)),
        )
    }

    private fun insertTriples(vararg triples: TriplePattern) {
        rdf4jTemplate.update(INSERT(*triples)).execute()
    }

}