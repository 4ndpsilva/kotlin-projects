package app.financeapi.service

import java.time.LocalDate
import java.util.DoubleSummaryStatistics
import org.springframework.stereotype.Service

import app.financeapi.service.LancamentoService
import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao
import app.financeapi.dto.ResultDTO


@Service
class DashboardService(private val serviceLancamento: LancamentoService){
  fun calculate(inicio: String, fim: String): List<ResultDTO>{
    val lancamentos = serviceLancamento.findByData(inicio, fim)
	val result = ResultDTO("", 0.0, "", 0.0, 0.0, 0.0)
	
	result.totalCategoria = lancamentos.filter{ it.categoria.id == 1L }.fold(0){ s, e -> s + e }
	
    val list = mutableListOf(result)
	return list
  } 
}