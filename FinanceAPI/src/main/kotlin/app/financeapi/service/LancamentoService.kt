package app.financeapi.service

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.constant.Constants
import app.financeapi.util.DateUtil
import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.Lancamento


@Service
class LancamentoService(private val repository: LancamentoRepository) : BaseService<Lancamento>(repository)