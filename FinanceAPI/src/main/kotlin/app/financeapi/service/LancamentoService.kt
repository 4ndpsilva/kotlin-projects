package app.financeapi.service

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao
import app.financeapi.dto.ParamsDTO


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository) {

	fun findByCategoria(idCategoria: Long): List<Lancamento> {
		return repository.findAll(Specification.where(QuerySpec.byCategoria(1)))
	}
	
	fun findByConta(idConta: Long) = repository.findByContaId(idConta)

	fun findByOperacao(operacao: Operacao) = repository.findByOperacao(operacao)

	fun find(dto: ParamsDTO): List<Lancamento> {
		return repository.findAll(Specification.where(
			QuerySpec.between(dto.dataInicio, dto.dataFim)
			.or(Specification.where(QuerySpec.byCategoria(1)))))
	}
}