package app.financeapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(("api/categorias")
class CategoriaController{
    @GetMapping
    fun categorias(): List<Categoria>{
	   return service.list()
	}
}