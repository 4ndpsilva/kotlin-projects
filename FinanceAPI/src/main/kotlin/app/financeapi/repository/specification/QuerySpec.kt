package app.financeapi.repository.specification

import java.time.LocalDate

import org.springframework.data.jpa.domain.Specification

import app.financeapi.entity.Lancamento

object QuerySpec{
  fun between(inicio: LocalDate, fim: LocalDate): Specification<Lancamento>{
    return Specification { root, _ , cb -> cb.between(root.get("data"), inicio, fim) }
  }
  
  /*
  fun byOperacao(operacao: Operacao): Specification<Lancamento>{
    return Specification { root, _ , cb -> cb.equals(root.get("operacao"), enumValueOf(operacao) }
  }
  
  fun byCategoria(idCategoria: Long): Unit{}
  
  fun byConta(idConta: Long): Unit{}
  */
}