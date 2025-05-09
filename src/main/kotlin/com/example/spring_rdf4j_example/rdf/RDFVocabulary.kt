package com.example.spring_rdf4j_example.rdf

import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Namespace
import org.eclipse.rdf4j.model.impl.SimpleNamespace
import org.eclipse.rdf4j.model.util.Values.iri

abstract class RDFVocabulary(prefix: String, namespace: String) {
    val namespace: Namespace = SimpleNamespace(prefix, namespace)

    protected fun localIRI(localName: String): IRI = iri(namespace.name, localName)
}
