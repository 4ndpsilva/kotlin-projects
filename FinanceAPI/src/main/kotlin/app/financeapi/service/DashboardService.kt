package app.financeapi.service

import java.time.LocalDate

import org.springframework.stereotype.Service

import app.financeapi.service.LancamentoService
import app.financeapi.entity.Lancamento
import app.financeapi.entity.OperacaoEnum
import app.financeapi.dto.ResultDTO
import app.financeapi.dto.ParamsDTO


@Service
class DashboardService(private val serviceLancamento: LancamentoService) {
	fun calculate(dto: ParamsDTO): List<ResultDTO> {
		val lancamentos = serviceLancamento.find(dto)

		val categoriasIds = mutableSetOf<Long>()
		lancamentos.forEach { categoriasIds.add(it.categoria.id) }

		val resultCategorias = mutableListOf<ResultDTO>()

		for (idCategoria in categoriasIds.sorted()) {
			val categoriaResultDTO = ResultDTO()
			val filteredCategoria = lancamentos.filter { it.categoria.id == idCategoria }

			categoriaResultDTO.descricao = filteredCategoria.map { it.categoria.descricao }.first()
			categoriaResultDTO.total = filteredCategoria.map { it.valor }.reduce { total, item -> total + item }

			val contasIds = mutableSetOf<Long>()
			val resultContas = mutableListOf<ResultDTO>()
			filteredCategoria.forEach { contasIds.add(it.conta.id) }

			for (idConta in contasIds.sorted()) {
				val contaResultDTO = ResultDTO()
				val filteredConta = filteredCategoria.filter { it.conta.id == idConta }

				contaResultDTO.descricao = filteredConta.map { it.conta.descricao }.first()
				contaResultDTO.total = filteredConta.map { it.valor }.reduce { total, item -> total + item }

				resultContas.add(contaResultDTO)
			}

			categoriaResultDTO.subitem = resultContas
			resultCategorias.add(categoriaResultDTO)
		}

		return resultCategorias
	}
}