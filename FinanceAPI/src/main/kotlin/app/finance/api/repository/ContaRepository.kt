package app.finance.api.repository

import app.finance.api.entity.Conta
import org.springframework.stereotype.Repository

@Repository
interface ContaRepository : BaseRepository<Conta>{}