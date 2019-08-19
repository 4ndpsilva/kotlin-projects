package app.financeapi.repository

import java.time.LocalDate

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Lancamento

@Repository
interface LancamentoRepository: BaseRepository<Lancamento>{
  fun findByDataBetween(inicio: LocalDate,  fim: LocalDate): List<Lancamento>
}