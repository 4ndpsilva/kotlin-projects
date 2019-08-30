package app.financeapi.dto

import java.time.LocalDateTime
import java.time.LocalDate

import app.financeapi.entity.Categoria
import app.financeapi.entity.Conta
import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao


data class ResponseDTO<T>(var data: T? = null, var list: List<T>? = null, var errors: List<String>? = null)
/*
data class ErrorResponseDTO(val code: Int?, val message: String?, val date: LocalDateTime?)

data class CategoriaDTO(val id: Long, val descricao: String)

data class ContaDTO(val id: Long, val descricao: String, val categoria: Categoria?)

data class LancamentoDTO(
	val id: Long,
	val data: LocalDate?, 
	val categoria: Categoria?, 
	val conta: Conta?, 
	val valor: Double?, 
	val operacao: Operacao?)
	*/
data class ResultDTO(var descricao: String = "", var total: Double = 0.0, var subitem: List<ResultDTO> = mutableListOf())