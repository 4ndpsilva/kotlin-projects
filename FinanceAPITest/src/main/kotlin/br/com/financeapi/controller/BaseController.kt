package br.com.financeapi.controller

import br.com.financeapi.document.BaseDocument
import br.com.financeapi.dto.ResponseDTO
import br.com.financeapi.service.BaseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

open class BaseController<T : BaseDocument>(private val service: BaseService<T>) {
    @PostMapping
    fun save(@RequestBody requestDTO: T): ResponseEntity<ResponseDTO<T>> {
        return ResponseEntity(ResponseDTO(service.save(requestDTO)), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody requestDTO: T): ResponseEntity<ResponseDTO<T>> {
        if (service.exists(id)) {
            return ResponseEntity(ResponseDTO(service.save(requestDTO)), HttpStatus.OK)
        }

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<T> {
        if (service.exists(id)) {
            service.delete(id)
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): ResponseEntity<ResponseDTO<T>> {
        val entity = service.findById(id)
        return if (entity != null) ResponseEntity(ResponseDTO(entity), HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun find(@RequestParam params: MutableMap<String, Any>): ResponseEntity<ResponseDTO<T>> {
        return ResponseEntity(ResponseDTO(dataSet = service.find(null)), HttpStatus.OK)
    }
}