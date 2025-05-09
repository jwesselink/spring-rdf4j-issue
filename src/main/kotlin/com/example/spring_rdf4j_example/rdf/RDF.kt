package com.example.spring_rdf4j_example.rdf

import org.eclipse.rdf4j.model.IRI

object RDF : RDFVocabulary("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#") {
    val type: IRI = localIRI("type")
}
