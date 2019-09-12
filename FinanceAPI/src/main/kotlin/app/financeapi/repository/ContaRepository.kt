package app.financeapi.repository

import org.springframework.stereotype.Repository

import app.financeapi.entity.Conta

@Repository
interface ContaRepository : BaseRepository<Conta>, CommonSelect<Conta> {}