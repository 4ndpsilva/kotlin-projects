package br.com.financeapi.document

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "entries")
data class Entry(
        var date: LocalDate = LocalDate.now(),
        @DBRef var category: Category,
        @DBRef var account: Account,
        var value: Double = 0.0,
        var observation: String = "") : BaseDocument()