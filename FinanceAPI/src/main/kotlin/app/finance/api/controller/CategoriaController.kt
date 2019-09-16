package app.finance.api.controller

import app.finance.api.entity.Categoria
import app.finance.api.request.CategoriaParams
import app.finance.api.service.CategoriaService
import app.finance.api.exception.ResourceNotFoundException
import app.finance.api.util.DateUtil
import app.finance.api.constant.Constants
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/categorias")
class CategoriaController(private val service: CategoriaService) :
        BaseController<Categoria>(service, CategoriaParams.parameters()){

    @GetMapping("/erro")
    fun teste(): Unit{
        // throw ResourceNotFoundException()
        // throw NumberFormatException()
        DateUtil.toLocalDate("ttt", Constants.DATE_FORMAT)
    }
}