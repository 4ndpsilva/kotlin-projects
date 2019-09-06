package app.financeapi.service

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.Lancamento
import app.financeapi.dto.ParamsDTO


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository) {
	fun find(dto: ParamsDTO): List<Lancamento> {
 	    var spec = Specification.where<Lancamento>(null)
		
		if(dto.dataInicio != null && dto.dataFim != null){
			spec = QuerySpec.between(dto.dataInicio, dto.dataFim)
		}
	   if(dto.idCategoria > 0){
			spec = spec.and(QuerySpec.byCategoria(dto.idCategoria))
		}
		if(dto.idConta > 0){
			spec = spec.and(QuerySpec.byConta(dto.idConta))
		}
		if(dto.operacao != null){
			spec = spec.and(QuerySpec.byOperacao(dto.operacao.toString()))
		}
		
		return repository.findAll(Specification.where<Lancamento>(spec))
	}
}