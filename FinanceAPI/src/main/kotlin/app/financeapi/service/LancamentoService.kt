package app.financeapi.service

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.LancamentoSpec
import app.financeapi.entity.Lancamento
import app.financeapi.dto.ParamsDTO


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository) {

	fun find(dto: ParamsDTO): List<Lancamento> {
	    val spec = Specification.where(
			LancamentoSpec.between(dto.dataInicio, dto.dataFim)
			.or(LancamentoSpec.byCategoria(dto.idCategoria))
			.or(LancamentoSpec.byConta(dto.idConta)))
		
		return repository.findAll(spec)
	}
}