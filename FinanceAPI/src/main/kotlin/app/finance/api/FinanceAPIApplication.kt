package app.finance.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FinanceAPIApplication

fun main(args: Array<String>) {
	SpringApplication.run(FinanceAPIApplication::class.java, *args)
}