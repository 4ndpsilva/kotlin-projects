package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.service.DashboardService
import app.financeapi.dto.ResponseDTO
import app.financeapi.entity.Categoria


@RestController
@RequestMapping("api/dashboard")
class DashboardController(private val service: DashboardService){
  @GetMapping("/data/{inicio:\\d{2}-\\d{2}-\\d{4}}/{fim:\\d{2}-\\d{2}-\\d{4}}")
  fun calculate(@PathVariable inicio: String, @PathVariable fim: String) = ResponseEntity(service.calculate(inicio, fim), HttpStatus.OK)
}