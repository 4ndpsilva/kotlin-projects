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
import app.financeapi.entity.BaseEntity


abstract class BaseController<BaseEntity>(private val service: BaseService<BaseEntity>){
	@PostMapping
	fun save(@RequestBody requestDTO: BaseEntity): ResponseEntity<BaseEntity>{
	   return ResponseEntity(service.save(requestDTO), HttpStatus.CREATED)
	}
	
	@PutMapping("/{id:\\d+}")
	fun update(@PathVariable("id") id: Long, @RequestBody requestDTO: BaseEntity): ResponseEntity<BaseEntity>{
	   return if(service.exists(id)) ResponseEntity(service.save(requestDTO), HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
	}
	
	@DeleteMapping("/{id:\\d+}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<BaseEntity>{	   
	   return if(service.exists(id)){
  	        service.delete(id) 
			ResponseEntity(HttpStatus.NO_CONTENT) 
		  }
		  else ResponseEntity(HttpStatus.NOT_FOUND)
	}
	
	@GetMapping("/{id:\\d+}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<BaseEntity>{
	   val entity = service.findById(id)
	   return if(entity != null) ResponseEntity(entity, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND) 	   
	}
	
    @GetMapping
    fun find(): ResponseEntity<List<BaseEntity>>{
	   return ResponseEntity(service.find(null), HttpStatus.OK)
	}
}