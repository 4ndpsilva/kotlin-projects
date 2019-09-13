package app.finance.api.dto

import java.time.LocalDateTime

data class ResponseDTO<T>(var data: T? = null, var list: List<T>? = null, var errors: List<String>? = null)

data class ErrorResponseDTO(val code: Int?, val message: String?, val date: LocalDateTime?)

data class ResultDTO(
	var descricao: String = "",
	var total: Double = 0.0,
	var subitem: List<ResultDTO> = mutableListOf()
)