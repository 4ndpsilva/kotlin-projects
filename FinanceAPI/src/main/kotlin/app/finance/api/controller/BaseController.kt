package app.finance.api.controller

import app.finance.api.entity.BaseEntity
import app.finance.api.request.RequestParametersValidator
import app.finance.api.service.BaseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

abstract class BaseController<T>(
		private val service: BaseService<T>,
		var listParams: List<String> = emptyList()) where T : BaseEntity<Long> {

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
	    if(!params.isEmpty()) {
			if (RequestParametersValidator.valid(listParams, params)) {
				return ResponseEntity(service.find(params), HttpStatus.OK)
			}
			else {
				return  ResponseEntity(HttpStatus.BAD_REQUEST)
			}
		}

		return ResponseEntity(service.find(null), HttpStatus.OK)
	}
}