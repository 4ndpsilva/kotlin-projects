package app.finance.api.controller

import app.finance.api.service.UsuarioService
import app.finance.api.constant.Constants
import app.finance.api.util.DateUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/dashboard")
class UsuarioController(private val service: UsuarioService) {
	
	 @GetMapping("/erro")
    fun teste(): Unit{
        // throw ResourceNotFoundException()
        // throw NumberFormatException()
        DateUtil.toLocalDate("ttt", Constants.DATE_FORMAT)
    }
}