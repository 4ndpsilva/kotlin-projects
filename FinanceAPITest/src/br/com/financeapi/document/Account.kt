package br.com.financeapi.document

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "accounts")
data class Account(
        var description: String = "",
        @DBRef var category: Category) : BaseDocument()