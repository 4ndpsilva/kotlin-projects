package app.financeapi.repository.specification

import java.time.LocalDate

import org.springframework.data.jpa.domain.Specification

import app.financeapi.entity.Lancamento

object QuerySpec{
  fun between(inicio: LocalDate, fim: LocalDate): Specification<Lancamento>{
    return Specification { root, _ , cb -> cb.between(root.get("data"), inicio, fim) }
  }
}