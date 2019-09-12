package app.financeapi.repository

import org.springframework.stereotype.Repository

import app.financeapi.entity.Lancamento

@Repository
interface LancamentoRepository : BaseRepository<Lancamento>, CommonSelect<Lancamento> {}