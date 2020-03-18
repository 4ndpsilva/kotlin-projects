package br.com.financeapi.controller

import br.com.financeapi.document.Entry
import br.com.financeapi.service.EntryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/lancamentos")
class EntryController(private var service: EntryService) : BaseController<Entry>(service)