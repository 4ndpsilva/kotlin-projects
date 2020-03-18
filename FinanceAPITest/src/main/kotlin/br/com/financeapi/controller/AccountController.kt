package br.com.financeapi.controller

import br.com.financeapi.document.Account
import br.com.financeapi.service.AccountService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/contas")
class AccountController(private var service: AccountService) : BaseController<Account>(service)