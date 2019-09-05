package app.financeapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import app.financeapi.constant.Constants
import app.financeapi.dto.ParamsDTO
import app.financeapi.dto.ResultDTO
import app.financeapi.service.DashboardService
import app.financeapi.util.DateUtil

@RestController
@RequestMapping("api/dashboard")
class DashboardController(private val service: DashboardService) {
	
	@GetMapping("/data/{inicio:\\d{2}-\\d{2}-\\d{4}}/{fim:\\d{2}-\\d{2}-\\d{4}}")
	fun calculate(@PathVariable inicio: String, @PathVariable fim: String): ResponseEntity<List<ResultDTO>> {
		val dto = ParamsDTO()
		dto.dataInicio = DateUtil.toLocalDate(inicio, Constants.DATE_FORMAT)
		dto.dataFim = DateUtil.toLocalDate(fim, Constants.DATE_FORMAT)
		return ResponseEntity(service.calculate(dto), HttpStatus.OK)
	}
}