package app.financeapi.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class ResponseDTO<T>(var data: T? = null, var list: List<T>? = null, var errors: List<String>? = null)

data class ErrorResponseDTO(val code: Int?, val message: String?, val date: LocalDateTime?)

data class ResultDTO(var descricao: String = "", var total: Double = 0.0, var subitem: List<ResultDTO> = mutableListOf())

open class BaseParamsDTO(var id: Long = 0L)

data class ParamsDTO(
	val idCategoria: Long? = 0L, 
	val idConta: Long? = 0L): BaseParamsDTO(){
	
	val dataInicial: LocalDate? = null
    set(str: String){ field = convertToLocalDate(str: String, format: String) }
 	
	val dataFinal: LocalDate? = null, 
    set(str: String){ field = convertToLocalDate(str: String, format: String) }
 	
	private fun convertToLocalDate(str: String, format: String) = LocalDate.parse(str, DateTimeFormatter.ofPattern(format)
}