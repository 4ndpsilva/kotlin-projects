package app.financeapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import app.financeapi.dto.ResultDTO
import app.financeapi.service.DashboardService

@RestController
@RequestMapping("api/dashboard")
class DashboardController(private val service: DashboardService) {
	
	@GetMapping
	fun calculate(@RequestParam params: MutableMap<String, Any>): ResponseEntity<List<ResultDTO>> {
		if(params.contains("inicio") && params.contains("fim")){
			return ResponseEntity(service.calculate(params), HttpStatus.OK)
		}
		
		return ResponseEntity(HttpStatus.BAD_REQUEST)
	}
}