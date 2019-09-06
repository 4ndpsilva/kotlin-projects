package app.financeapi.controller

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.dto.ParamsDTO
import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao
import app.financeapi.service.LancamentoService
import app.financeapi.util.DateUtil
import app.financeapi.constant.Constants


@RestController
@RequestMapping("api/lancamentos")
class LancamentoController(private val service: LancamentoService) : BaseController<Lancamento>(service) {

	@GetMapping("/data/{inicio:\\d{2}-\\d{2}-\\d{4}}/{fim:\\d{2}-\\d{2}-\\d{4}}")
	fun findByData(@PathVariable inicio: String, @PathVariable fim: String): ResponseEntity<List<Lancamento>> {
		val dto = ParamsDTO()
		dto.dataInicio = DateUtil.toLocalDate(inicio, Constants.DATE_FORMAT)
		dto.dataFim = DateUtil.toLocalDate(fim, Constants.DATE_FORMAT)
		return find(dto)
	}

	@GetMapping("/categoria/{idCategoria:\\d+}")
	fun findByCategoria(@PathVariable idCategoria: Long): ResponseEntity<List<Lancamento>> {
		val dto = ParamsDTO()
		dto.idCategoria = idCategoria
		return find(dto)
	}

	@GetMapping("/conta/{idConta:\\d+}")
	fun findByConta(@PathVariable idConta: Long): ResponseEntity<List<Lancamento>> {
		val dto = ParamsDTO()
		dto.idConta = idConta
		return find(dto)
	}

	@GetMapping("/operacao/{operacao:[a-zA-Z]+}")
	fun findByOperacao(@PathVariable operacao: String): ResponseEntity<List<Lancamento>> {
		val dto = ParamsDTO()
		dto.operacao = when(operacao.toUpperCase()){
			"debito".toUpperCase() -> Operacao.DEBITO
			"credito".toUpperCase() -> Operacao.CREDITO
			else -> return ResponseEntity(HttpStatus.NOT_FOUND)
		}
		
		return find(dto)
	}

	private fun find(dto: ParamsDTO) = ResponseEntity(service.find(dto), HttpStatus.OK)
}