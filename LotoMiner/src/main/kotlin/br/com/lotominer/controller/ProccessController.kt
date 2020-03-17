package br.com.lotominer.controller

import br.com.lotominer.dto.TotalizerDTO
import br.com.lotominer.service.AnalizerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loto-miner/lotofacil")
@CrossOrigin("*")
class ProccessController(val service: AnalizerService) {
    @GetMapping
    fun compute(): ResponseEntity<TotalizerDTO>{
        val dto = service.compute()
        return ResponseEntity(dto, HttpStatus.OK)
    }
}