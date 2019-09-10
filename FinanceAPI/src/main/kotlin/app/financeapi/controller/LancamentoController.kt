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

import app.financeapi.entity.Lancamento
import app.financeapi.entity.OperacaoEnum
import app.financeapi.service.LancamentoService
import app.financeapi.constant.Constants
import app.financeapi.util.DateUtil


@RestController
@RequestMapping("api/lancamentos")
class LancamentoController(private val service: LancamentoService) : BaseController<Lancamento>(service) {

	@GetMapping("/categoria/{idCategoria:\\d+}")
	fun findByCategoria(@PathVariable idCategoria: Long): ResponseEntity<List<Lancamento>> {
		val params = LinkedHashMap<String, Any>()
		params.put("idCategoria", idCategoria)
		return search(params)
	}

	@GetMapping("/conta/{idConta:\\d+}")
	fun findByConta(@PathVariable idConta: Long): ResponseEntity<List<Lancamento>> {
		val params = LinkedHashMap<String, Any>()
		params.put("idConta", idConta)
		return search(params)
	}

	@GetMapping("/operacao/{op:[a-zA-Z]+}")
	fun findByOperacao(@PathVariable op: String): ResponseEntity<List<Lancamento>> {
		val operacao = when(op.toUpperCase()){
			"debito".toUpperCase() -> OperacaoEnum.DEBITO
			"credito".toUpperCase() -> OperacaoEnum.CREDITO
			else -> return ResponseEntity(HttpStatus.NOT_FOUND)
		}
		
		val params = LinkedHashMap<String, Any>()
		params.put("operacao", operacao)
		return search(params)
	}

	private fun search(params: MutableMap<String, Any>) = ResponseEntity(service.find(params), HttpStatus.OK)
}