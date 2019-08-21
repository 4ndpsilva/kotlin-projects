package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.entity.Lancamento
import app.financeapi.service.LancamentoService

@RestController
@RequestMapping("{base.url}/lancamentos")
class LancamentoController(private val service: LancamentoService): BaseController<Lancamento>(service){
	//@GetMapping("/data/{inicio:\\d{2}-\\d{2}-\\d{4}}/{fim:\\d{2}-\\d{2}-\\d{4}}")
	@GetMapping("/data/{inicio:${regex.date}}/{fim:${regex.date}}")
    fun findByData(@PathVariable("inicio") inicio: String, @PathVariable("fim") fim: String?) = ResponseEntity(service.findByData(inicio, fim), HttpStatus.OK)
	
	@GetMapping("/categoria/{id:${regex.int}}")
	fun findByCategoria(idCategoria: Long) = ResponseEntity(service.findByCategoria(idCategoria), HttpStatus.OK)
  
    @GetMapping("/conta/{id:${regex.int}}")
    fun findByConta(idConta: Long) = ResponseEntity(service.findByConta(idConta), HttpStatus.OK)
	
	@GetMapping("/operacao/{operacao}")
    fun findByOperacao(@PathVariable("operacao") operacao: String) = ResponseEntity(service.findByOperacao(operacao), HttpStatus.OK)
}