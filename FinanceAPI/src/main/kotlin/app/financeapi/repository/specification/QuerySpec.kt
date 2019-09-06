package app.financeapi.repository.specification

import app.financeapi.entity.Lancamento
import app.financeapi.entity.OperacaoEnum
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

object QuerySpec{
	fun between(inicio: LocalDate?, fim: LocalDate?): Specification<Lancamento> {
		return Specification { root, _, cb -> cb.between(root.get<LocalDate>("data"), inicio, fim) }
	}
	
	fun byCategoria(idCategoria: Long): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("categoria"), idCategoria) }
	}
	
	fun byConta(idConta: Long): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("conta"), idConta) }
	}
	
	fun byOperacao(operacao: String): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<OperacaoEnum>("operacao"), OperacaoEnum.valueOf(operacao)) }
	}
	
	fun byLike(field: String = "descricao", term: String): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.like(root.get<String>(field), "%${term}%") }
	}
}