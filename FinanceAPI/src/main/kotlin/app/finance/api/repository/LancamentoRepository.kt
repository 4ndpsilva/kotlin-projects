package app.finance.api.repository

import app.finance.api.entity.Lancamento
import org.springframework.stereotype.Repository

@Repository
interface LancamentoRepository : BaseRepository<Lancamento> {}