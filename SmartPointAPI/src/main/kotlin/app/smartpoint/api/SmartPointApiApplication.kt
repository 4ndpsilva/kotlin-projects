package app.smartpoint.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartPointApiApplication

fun main(args: Array<String>) {
	runApplication<SmartPointApiApplication>(*args)
}
