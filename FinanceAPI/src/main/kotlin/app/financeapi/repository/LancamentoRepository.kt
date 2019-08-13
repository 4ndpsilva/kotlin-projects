package app.financeapi.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Lancamento

@Repository
interface LancamentoRepository: BaseRepository<Lancamento>{}