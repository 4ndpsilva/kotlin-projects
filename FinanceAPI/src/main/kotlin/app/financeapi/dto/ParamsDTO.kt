package app.financeapi.dto

import java.time.LocalDate

open class BaseParamsDTO(var id: Long = 0L)

data class ParamsDTO(
	var dataInicio: LocalDate? = null,
	var dataFim: LocalDate? = null,
	var idCategoria: Long = 0L,
	var idConta: Long = 0L
) : BaseParamsDTO()