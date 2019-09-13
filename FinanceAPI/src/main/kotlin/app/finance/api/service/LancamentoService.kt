package app.finance.api.service

import app.finance.api.entity.Lancamento
import app.finance.api.repository.LancamentoRepository
import org.springframework.stereotype.Service


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository)