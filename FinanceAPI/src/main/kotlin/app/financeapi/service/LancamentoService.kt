package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.entity.Lancamento
import app.financeapi.repository.LancamentoRepository

@Service
class LancamentoService(private val repository: LancamentoRepository): BaseService<Lancamento>(repository)