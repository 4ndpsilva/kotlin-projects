package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

import app.financeapi.entity.Conta
import app.financeapi.service.ContaService

@RestController
@RequestMapping("api/contas")
class ContaController(private val service: ContaService): BaseController<Conta>(service)