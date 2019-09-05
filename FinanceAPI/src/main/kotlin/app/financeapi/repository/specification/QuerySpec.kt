package app.financeapi.repository.specification

import app.financeapi.entity.Lancamento
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate
import javax.persistence.criteria.Expression

object QuerySpec {
	fun between(inicio: LocalDate?, fim: LocalDate?): Specification<Lancamento> {
		return Specification { root, _, cb -> cb.between(root.get<LocalDate>("data"), inicio, fim) }
	}
	
	fun byCategoria(idCategoria: Long): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("categoria_id"), idCategoria)}
	}
	
	fun byConta(idConta: Long): Specification<Lancamento>{
		return Specification{ root, _, cb -> cb.equal(root.get<Long>("conta_id"), idConta)}
	}
}