package app.financeapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.WebDataBinder

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.controller.converter.OperacaoEnumConverter

import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao
import app.financeapi.service.LancamentoService


@RestController
@RequestMapping("api/lancamentos")
class LancamentoController(private val service: LancamentoService): BaseController<Lancamento>(service){
    @GetMapping("/data/{inicio:\\d{2}-\\d{2}-\\d{4}}/{fim:\\d{2}-\\d{2}-\\d{4}}")
    fun findByData(@PathVariable inicio: String, @PathVariable fim: String) = ResponseEntity(service.find(inicio, fim), HttpStatus.OK)

	@GetMapping("/categoria/{idCategoria:\\d+}")
	fun findByCategoria(@PathVariable idCategoria: Long) = ResponseEntity(service.findByCategoria(idCategoria), HttpStatus.OK)
  
    @GetMapping("/conta/{idConta:\\d+}")
    fun findByConta(@PathVariable idConta: Long) = ResponseEntity(service.findByConta(idConta), HttpStatus.OK)
	
	@GetMapping("/operacao/{operacao}")
    fun findByOperacao(@PathVariable operacao: Operacao) = ResponseEntity(service.findByOperacao(operacao), HttpStatus.OK)
	
	/*
	@InitBinder
	fun initBinder(binder: WebDataBinder){
	  binder.registerCustomEditor(Operacao::class.java, OperacaoEnumConverter())
	}
	*/
}