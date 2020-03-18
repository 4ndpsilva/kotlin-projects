package br.com.financeapi.document

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "categories")
data class Category(var description: String = "") : BaseDocument()