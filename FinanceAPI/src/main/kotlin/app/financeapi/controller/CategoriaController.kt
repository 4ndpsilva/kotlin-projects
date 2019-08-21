package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

import app.financeapi.entity.Categoria
import app.financeapi.service.CategoriaService

@RestController
@RequestMapping("{base.url}/categorias")
class CategoriaController(private val service: CategoriaService): BaseController<Categoria>(service)