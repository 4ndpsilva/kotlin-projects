package br.com.financeapi.document

import org.springframework.data.annotation.Id

open class BaseDocument(@Id var id: String? = null)