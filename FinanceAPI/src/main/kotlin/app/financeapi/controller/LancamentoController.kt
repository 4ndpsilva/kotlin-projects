package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

import app.financeapi.entity.Lancamento
import app.financeapi.service.LancamentoService

@RestController
@RequestMapping("api/lancamentos")
class LancamentoController(private val service: LancamentoService): BaseController<Lancamento>(service)