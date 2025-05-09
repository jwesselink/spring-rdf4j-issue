package com.example.spring_rdf4j_example.rdf

import org.eclipse.rdf4j.model.Value
import org.eclipse.rdf4j.query.BindingSet
import org.eclipse.rdf4j.sparqlbuilder.core.query.ModifyQuery
import org.eclipse.rdf4j.spring.dao.support.opbuilder.UpdateExecutionBuilder
import org.eclipse.rdf4j.spring.support.RDF4JTemplate

operator fun BindingSet.get(varName: String): Value = this.getValue(varName)

fun RDF4JTemplate.update(query: ModifyQuery): UpdateExecutionBuilder = update(query.queryString)
