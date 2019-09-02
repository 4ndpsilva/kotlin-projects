package app.financeapi.repository.specification

import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Root
import javax.persistence.criteria.Predicate

import java.time.LocalDate

import org.springframework.data.jpa.domain.Specification

import app.financeapi.entity.Lancamento


abstract class DateBetweenSpec(val inicio: LocalDate, val fim: LocalDate): Specification<Lancamento>{
  fun toPredicate(root: Root<Lancamento>, query: CriteriaQuery<Lancamento>, cb: CriteriaBuilder): Predicate{    
    return query.where(cb.between(root.get("Data"), inicio, fim))
  }
}