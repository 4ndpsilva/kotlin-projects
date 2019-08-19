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
@RequestMapping("api/lancamentos")
class LancamentoController(private val service: LancamentoService): BaseController<Lancamento>(service){
    @GetMapping("/data/{inicio}/{fim}")
    fun listByData(@PathVariable("inicio") inicio: String, @PathVariable("fim") fim: String?): ResponseEntity<List<Lancamento>>{
	   return ResponseEntity(service.listByData(inicio, fim), HttpStatus.OK)
	}
}