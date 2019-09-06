package app.financeapi.repository.specification

import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

object LancamentoSpec {
	fun between(inicio: LocalDate?, fim: LocalDate?): Specification<Lancamento> {
		return Specification { root, _, cb -> cb.between(root.get<LocalDate>("data"), inicio, fim) }
	}
	
	fun byCategoria(idCategoria: Long): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("categoria"), idCategoria)}
	}
	
	fun byConta(idConta: Long): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("conta"), idConta)}
	}
	
	fun byOperacao(operacao: String): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Operacao>("operacao"), Operacao.valueOf(operacao))}
	}
	
	fun byLike(field: String, term: String): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.like(root.get<String>(field), "%${term}%")}
	}
}