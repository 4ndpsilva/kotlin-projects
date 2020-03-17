package br.com.lotominer.controller

import br.com.lotominer.document.LotoFacil
import br.com.lotominer.dto.ResponseDTO
import br.com.lotominer.service.ExtractorService
import br.com.lotominer.service.LotoFacilService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/lotofacil")
@CrossOrigin("*")
class LotoFacilController(private var service: LotoFacilService) {
    @PostMapping("/load")
    fun load(): ResponseEntity<ResponseDTO<Int>> {
        val dataSet = ExtractorService.extract()
        val result = service.save(dataSet)
        return ResponseEntity(ResponseDTO(result.size), HttpStatus.OK)
    }

    @GetMapping("/{numberOfContest}")
    fun findByContest(@PathVariable("numberOfContest") numberOfContest: Int): ResponseEntity<ResponseDTO<LotoFacil>> {
        var result = service.findByContest(numberOfContest)
        return ResponseEntity(ResponseDTO(result), HttpStatus.OK)
    }

    @GetMapping
    fun findAll() : ResponseEntity<ResponseDTO<List<LotoFacil>>>{
        val result = service.findAll()
        return ResponseEntity(ResponseDTO(result), HttpStatus.OK)
    }

    @GetMapping("/count")
    fun count() = service.count()

    @DeleteMapping
    fun deleteAll(): ResponseEntity<Any>{
        service.deleteAll()
        return ResponseEntity.noContent().build()
    }
}