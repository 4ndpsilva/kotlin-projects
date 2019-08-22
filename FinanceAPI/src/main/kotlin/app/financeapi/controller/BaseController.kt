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
	   return ResponseEntity(service.save(requestDTO), HttpStatus.CREATED)
	}
	
	@PutMapping("/{id:\\d+}")
	fun update(@PathVariable("id") id: Long, @RequestBody requestDTO: T): ResponseEntity<T>{
	   return if(service.findById(id) != null) ResponseEntity(service.save(requestDTO), HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
	}
	
	@DeleteMapping("/{id:\\d+}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<T>{
	   service.delete(id) 
	   return ResponseEntity(HttpStatus.NO_CONTENT)
	}
	
	@GetMapping("/{id:\\d+}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<T>{
	   val entity = service.findById(id)
	   return if(entity != null) ResponseEntity(entity, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND) 	   
	}
	
    @GetMapping
    fun findAll(): ResponseEntity<List<T>>{
	   return ResponseEntity(service.findAll(), HttpStatus.OK)
	}
}