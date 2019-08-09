package app.financeapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import app.financeapi.entity.Conta

@RestController
@RequestMapping("api/contas")
class ContaController{
    @GetMapping	
	fun contas(): List<Conta>{
	    var categs = categorias();
	
	    val c1 = Conta(1, "Bolacha", categs[0])
		val c2 = Conta(2, "Arroz", categs[0])
		val c3 = Conta(3, "Feijao", categs[0])
		val c4 = Conta(4, "Uber", categs[1])
		val c5 = Conta(5, "Moto Taxi", categs[1])
		val c6 = Conta(6, "Salario", categs[2])
		val c7 = Conta(7, "Poupança", categs[2])
		
		return listOf(c1, c2, c3, c4, c5, c6, c7)  
	}
}