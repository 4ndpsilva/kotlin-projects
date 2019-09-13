package app.finance.api.controller

import app.finance.api.entity.Conta
import app.finance.api.request.ContaParams
import app.finance.api.service.ContaService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/contas")
class ContaController(private val service: ContaService) :
        BaseController<Conta>(service, ContaParams.parameters())