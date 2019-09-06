package app.financeapi.dto

import java.time.LocalDate
import app.financeapi.entity.OperacaoEnum

open class BaseParamsDTO(var id: Long = 0L, var termo: String? = null)

data class ParamsDTO(
	var dataInicio: LocalDate? = null,
	var dataFim: LocalDate? = null,
	var idCategoria: Long = 0L,
	var idConta: Long = 0L,
	var operacao: OperacaoEnum? = null
) : BaseParamsDTO()