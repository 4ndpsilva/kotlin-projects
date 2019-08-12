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

import app.financeapi.service.CategoriaService
import app.financeapi.entity.Categoria

@RestController
@RequestMapping("api/categorias")
class CategoriaController(private val service: CategoriaService){
    @PostMapping
	fun save(@RequestBody request: Categoria): ResponseEntity<Categoria>{
	   service.save(request) 
	   return ResponseEntity(HttpStatus.CREATED)
	}
	
	@DeleteMapping("/{id}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<Categoria>{
	   service.delete(id) 
	   return ResponseEntity(HttpStatus.NO_CONTENT)
	}
	
	@GetMapping("/{id}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<Categoria>{
	   val entity = service.findById(id) 
	   return ResponseEntity(entity, HttpStatus.OK)
	}
	
    @GetMapping
    fun list(): ResponseEntity<List<Categoria>>{
	   return ResponseEntity.ok(service.list())
	}
}