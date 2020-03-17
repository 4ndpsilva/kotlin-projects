package br.com.financeapi.controller

import br.com.financeapi.document.Category
import br.com.financeapi.service.CategoryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/categorias")
class CategoryController(private var service: CategoryService) : BaseController<Category>(service)