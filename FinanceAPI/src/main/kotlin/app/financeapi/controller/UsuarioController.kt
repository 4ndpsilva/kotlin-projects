package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.entity.Usuario
import app.financeapi.service.UsuarioService

@RestController
@RequestMapping("api/usuarios")
class UsuarioController(private val service: UsuarioService) : BaseController<Usuario>(service) {}