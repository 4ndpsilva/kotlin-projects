package app.financeapi.repository

import java.time.LocalDate

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao

@Repository
interface LancamentoRepository : BaseRepository<Lancamento> {}