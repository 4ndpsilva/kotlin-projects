package app.finance.api.controller

import app.finance.api.entity.BaseEntity
import app.finance.api.entity.Usuario
import app.finance.api.entity.PK
import app.finance.api.constant.Constants
import app.finance.api.service.BaseService
import app.finance.api.request.RequestParametersValidator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam


abstract class BaseController<T>(
		private val service: BaseService<T>,
		var listParams: List<String> = emptyList()) where T : BaseEntity {
	
	var usuario: Long = 1
	
	@PostMapping
	fun save(@RequestBody requestDTO: T): ResponseEntity<T> {
		return ResponseEntity(service.save(requestDTO), HttpStatus.CREATED)
	}

	@PutMapping("/{id:\\d+}")
	fun update(@PathVariable("id") id: Long, @RequestBody requestDTO: T): ResponseEntity<T> {
		val pk = PK(id, usuario)
		
		if (service.exists(pk)){ 
		    requestDTO.id = id
			requestDTO.usuario = Usuario(1)
			return ResponseEntity(service.save(requestDTO), HttpStatus.OK) 
		}
		
		return ResponseEntity(HttpStatus.NOT_FOUND)
	}

	@DeleteMapping("/{id:\\d+}")
	fun delete(@PathVariable("id") id: Long): ResponseEntity<T> {
		val pk = PK(id, usuario)
		
		if (service.exists(pk)) {
			service.delete(pk)
			return ResponseEntity(HttpStatus.NO_CONTENT)
		} 
		
		return ResponseEntity(HttpStatus.NOT_FOUND)
	}

	@GetMapping("/{id:\\d+}")
	fun findById(@PathVariable("id") id: Long): ResponseEntity<T> {
		val pk = PK(id, usuario)
		val entity = service.findById(pk)
		return if (entity != null) ResponseEntity(entity, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
	}
	
	@GetMapping
	fun find(@RequestParam params: MutableMap<String, Any>): ResponseEntity<List<T>> {
		params.put(Constants.USUARIO, usuario)
		
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