package app.finance.api.controller

import app.finance.api.entity.Categoria
import app.finance.api.request.CategoriaParams
import app.finance.api.service.CategoriaService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/categorias")
class CategoriaController(private val service: CategoriaService) :
        BaseController<Categoria>(service, CategoriaParams.parameters())