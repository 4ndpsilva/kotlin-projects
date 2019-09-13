package app.finance.api.service

import app.finance.api.entity.Conta
import app.finance.api.repository.ContaRepository
import org.springframework.stereotype.Service


@Service
class ContaService(private val repository: ContaRepository) : BaseService<Conta>(repository)