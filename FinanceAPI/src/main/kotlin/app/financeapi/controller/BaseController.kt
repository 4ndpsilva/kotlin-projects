package app.financeapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.service.BaseService


abstract class BaseController<T>(private val service: BaseService<T>){
	@PostMapping
	fun save(@RequestBody requestDTO: T): ResponseEntity<T>{
	   service.save(requestDTO) 
	   return ResponseEntity(HttpStatus.CREATED)
	}
	
	@PutMapping("/{id}")
	fun update(@PathVariable("id") id: Long, @RequestBody requestDTO: Any): ResponseEntity<T>{
	   var entity: T = requestDTO as T
	   
	   if(service.findById(id) != null){
	     service.save(entity) 
		 return ResponseEntity(HttpStatus.OK)
	   }
	   
	   return ResponseEntity(HttpStatus.NOT_FOUND)
	}
	
	@DeleteMapping("/{id}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<T>{
	   service.delete(id) 
	   return ResponseEntity(HttpStatus.NO_CONTENT)
	}
	
	@GetMapping("/{id}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<T>{
	   val entity = service.findById(id) 
	   return ResponseEntity(entity, HttpStatus.OK)
	}
	
    @GetMapping
    fun list(): ResponseEntity<List<T>>{
	   return ResponseEntity(service.list(), HttpStatus.OK)
	}
}