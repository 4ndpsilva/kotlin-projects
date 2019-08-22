package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.service.DashboardService
import app.financeapi.dto.ResponseDTO
import app.financeapi.entity.Categoria


@RestController
@RequestMapping("api/dashboard")
class DashboardController(private val service: DashboardService){
  fun index() = ResponseEntity(ResponseDTO<Categoria>(), HttpStatus.OK)
}