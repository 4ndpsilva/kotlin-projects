package aps.judicialagreement.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class IndexController {
    @GetMapping
    fun index() = listOf("item 1", "item 2", "item 3")
}