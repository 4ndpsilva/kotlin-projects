package app.financeapi.repository

import java.time.LocalDate

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Lancamento

@Repository
interface LancamentoRepository: BaseRepository<Lancamento>{
  fun findByDataBetweenOrderByDataDesc(inicio: LocalDate, fim: LocalDate): List<Lancamento>
  
  fun findByCategoriaId(idCategoria: Long): List<Lancamento>
  
  fun findByContaId(idConta: Long): List<Lancamento>
  
  fun findByOperacao(operacao: String): List<Lancamento>
}