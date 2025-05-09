package com.example.spring_rdf4j_example.rdf

import org.eclipse.rdf4j.model.IRI
import java.util.*

object PK : RDFVocabulary("pk", "http://demo.net/") {
    fun production(id: UUID): IRI = localIRI("production/$id")
}
