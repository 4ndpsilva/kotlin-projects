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
	val result = mutableListOf<ResultDTO>()
  
    for(idCategoria in categoriasIds.sorted()){
	  val dto = ResultDTO()
	  val filteredCategoria = lancamentos.filter{ it.categoria.id == idCategoria }	
	
	  dto.categoria = filteredCategoria.map{ it.categoria.descricao }.first()
	  dto.totalCategoria = filteredCategoria.map{ it.valor }.reduce{ total, item -> total + item }   
	
	  filteredCategoria.forEach{ contasIds.add(it.conta.id) }
      
/*	  
	  for(idConta in contasIds.sorted()){
	    val filteredConta = filteredCategoria.filter{ it.conta.id == idConta }	
	
	    dto.conta = filteredConta.map{ it.conta.descricao }.first()
	    dto.totalConta = filteredConta.map{ it.valor }.reduce{ total, item -> total + item } 
	  }	
	*/
    val list = mutableListOf(result)
	return list
  } 
}