package app.financeapi.repository.specification

import app.financeapi.entity.Lancamento
import app.financeapi.entity.OperacaoEnum
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

object QuerySpec{
	fun <T> between(inicio: LocalDate?, fim: LocalDate?): Specification<T> {
		return Specification { root, _, cb -> cb.between(root.get<LocalDate>("data"), inicio, fim) }
	}
	
	fun <T> byId(id: Long): Specification<T>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("id"), id) }
	}
	
	fun <T> byUsuario(idUsuario: Long): Specification<T>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("usuario"), idUsuario) }
	}
	
	fun <T> byCategoria(idCategoria: Long): Specification<T>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("categoria"), idCategoria) }
	}
	
	fun <T> byConta(idConta: Long): Specification<T>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("conta"), idConta) }
	}
	
	fun <T> byOperacao(operacao: String): Specification<T>{
		return Specification{ root, _, cb -> cb.equal(root.get<OperacaoEnum>("operacao"), OperacaoEnum.valueOf(operacao)) }
	}
	
	fun <T> byLike(term: String, field: String? = "descricao"): Specification<T>{
		return Specification{ root, _, cb -> cb.like(root.get<String>(field), "%${term}%") }
	}
}