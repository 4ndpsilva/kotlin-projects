package app.financeapi.service

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.constant.Constants
import app.financeapi.entity.Conta
import app.financeapi.repository.ContaRepository
import app.financeapi.repository.specification.QuerySpec


@Service
class ContaService(private val repository: ContaRepository) : BaseService<Conta>(repository)