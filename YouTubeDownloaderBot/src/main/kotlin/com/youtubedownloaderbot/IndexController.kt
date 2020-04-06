package com.youtubedownloaderbot

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/downloader")
class IndexController {
    @PostMapping
    fun execute(@RequestBody bubaseUrl: String): ResponseEntity<String>{
        return ResponseEntity.ok("Executar URL: $baseUrl")
    }
}