package com.youtubedownloaderbot

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/downloader")
class IndexController {
    @PostMapping
    fun execute(@RequestBody baseUrl: String): ResponseEntity<String>{
        return ResponseEntity.ok("Executar URL: $baseUrl")
    }

    @GetMapping
    fun test(): ResponseEntity<String>{
        val crawler = Crawler()
        return ResponseEntity(crawler.execute(), HttpStatus.OK)
    }
}