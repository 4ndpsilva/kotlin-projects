package app.financeapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.service.ContaService
import app.financeapi.entity.Conta

@RestController
@RequestMapping("api/contas")
class ContaController(private val service: ContaService){
    @PostMapping
	fun save(@RequestBody request: Conta): ResponseEntity<Conta>{
	   service.save(request) 
	   return ResponseEntity(HttpStatus.CREATED)
	}
	
	@DeleteMapping("/{id}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<Conta>{
	   service.delete(id) 
	   return ResponseEntity(HttpStatus.NO_CONTENT)
	}
	
	@GetMapping("/{id}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<Conta>{
	   val entity = service.findById(id) 
	   return ResponseEntity(entity, HttpStatus.OK)
	}
	
    @GetMapping
    fun list(): ResponseEntity<List<Conta>>{
	   return ResponseEntity.ok(service.list())
	}
}