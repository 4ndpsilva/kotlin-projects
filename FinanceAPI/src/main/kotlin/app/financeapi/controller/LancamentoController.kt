package app.financeapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import java.time.LocalDate

import app.financeapi.entity.Lancamento


@RestController
@RequestMapping("api/lancamentos")
class LancamentoController{
    /*
	@GetMapping
	fun lancamentos(): List<Lancamento>{
	    var contas = contas();
		
  	    val lanc1 = Lancamento(1, LocalDate.of(2019, 5, 1), contas[0].categoria, contas[0], 1.79, Operacao.DEBITO.value)
		val lanc2 = Lancamento(2, LocalDate.of(2019, 5, 3), contas[0].categoria, contas[0], 1.79, Operacao.DEBITO.value)
		val lanc3 = Lancamento(3, LocalDate.of(2019, 5, 4), contas[0].categoria, contas[0], 1.79, Operacao.DEBITO.value)
		val lanc4 = Lancamento(4, LocalDate.of(2019, 6, 3), contas[3].categoria, contas[3], 1.79, Operacao.DEBITO.value)
		val lanc5 = Lancamento(5, LocalDate.of(2019, 6, 10), contas[4].categoria, contas[4], 1.79, Operacao.DEBITO.value)
		val lanc6 = Lancamento(6, LocalDate.of(2019, 7, 15), contas[2].categoria, contas[2], 1.79, Operacao.DEBITO.value)
		val lanc7 = Lancamento(7, LocalDate.of(2019, 7, 5), contas[5].categoria, contas[5], 2000.00, Operacao.CREDITO.value)
		val lanc8 = Lancamento(8, LocalDate.of(2019, 7, 5), contas[6].categoria, contas[6], 900.00, Operacao.CREDITO.value)
		val lanc9 = Lancamento(9, LocalDate.of(2019, 8, 5), contas[3].categoria, contas[3], 15.00, Operacao.DEBITO.value)
		val lanc10 = Lancamento(10, LocalDate.of(2019, 7, 29), contas[0].categoria, contas[1], 20.50, Operacao.DEBITO.value)
		val lancamentos = mutableListOf(lanc1, lanc2, lanc3, lanc4, lanc5, lanc6, lanc7)
		lancamentos.add(lanc8)
		lancamentos.add(lanc9)
		lancamentos.add(lanc10)
		
		return lancamentos;
	}
	*/
}