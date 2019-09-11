package app.financeapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

import app.financeapi.service.BaseService
import app.financeapi.entity.BaseEntity
import app.financeapi.util.RequestParametersUtil


abstract class BaseController<T>(private val service: BaseService<T>) where T : BaseEntity<Long> {
	@PostMapping
	fun save(@RequestBody requestDTO: T): ResponseEntity<T> {
		return ResponseEntity(service.save(requestDTO), HttpStatus.CREATED)
	}

	@PutMapping("/{id:\\d+}")
	fun update(@PathVariable("id") id: Long, @RequestBody requestDTO: T): ResponseEntity<T> {
		if (service.exists(id)){ 
		    requestDTO.id = id
			return ResponseEntity(service.save(requestDTO), HttpStatus.OK) 
		}
		
		return ResponseEntity(HttpStatus.NOT_FOUND)
	}

	@DeleteMapping("/{id:\\d+}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<T> {
		if (service.exists(id)) {
			service.delete(id)
			return ResponseEntity(HttpStatus.NO_CONTENT)
		} 
		
		return ResponseEntity(HttpStatus.NOT_FOUND)
	}

	@GetMapping("/{id:\\d+}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<T> {
		val entity = service.findById(id)
		return if (entity != null) ResponseEntity(entity, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
	}
	
	@GetMapping
	fun find(@RequestParam params: MutableMap<String, Any>): ResponseEntity<List<T>> {
	    return if(RequestParametersUtil.valid(params)) ResponseEntity(service.find(params), HttpStatus.OK) else ResponseEntity(HttpStatus.BAD_REQUEST)
	}
}