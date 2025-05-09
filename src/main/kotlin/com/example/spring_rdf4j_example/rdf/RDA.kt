package com.example.spring_rdf4j_example.rdf

import org.eclipse.rdf4j.model.IRI

object RDA {
    object Work : RDFVocabulary("rdae", "http://rdaregistry.info/Elements/w/") {
        val hasTitleOfWork: IRI = localIRI("P10088")
    }

    object Classes : RDFVocabulary("rdac", "http://rdaregistry.info/Elements/c/") {
        val work: IRI = localIRI("C10001")
        val expression: IRI = localIRI("C10006")
    }
}
