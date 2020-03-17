package br.com.lotominer.document

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "lotofacil")
data class LotoFacil(var prize15: Double = 0.0, var prize14: Double = 0.0) : BaseDocument()