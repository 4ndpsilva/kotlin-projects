package br.com.lotominer.dto

data class ResponseDTO<T>(private var data: T? = null, private var dataSet: List<T> = emptyList())