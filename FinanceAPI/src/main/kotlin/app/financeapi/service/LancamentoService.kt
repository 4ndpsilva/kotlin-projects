package app.financeapi.service

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.springframework.stereotype.Service

import app.financeapi.entity.Lancamento
import app.financeapi.repository.LancamentoRepository

@Service
class LancamentoService(private val repository: LancamentoRepository): BaseService<Lancamento>(repository){
  
    fun findByData(inicio: String, fim: String?): List<Lancamento>{
       val format = DateTimeFormatter.ofPattern("dd-MM-yyyy")	  
  	   val dataInicio = LocalDate.parse(inicio, format) 
	   val dataFim = LocalDate.parse(fim, format) 
	  
	   return repository.findByDataBetweenOrderByDataDesc(dataInicio, dataFim)
	}
	
	fun findByCategoria(idCategoria: Long) = repository.findByCategoriaId(idCategoria)
    
	fun findByConta(idConta: Long) = repository.findByContaId(idConta)
    
	fun findByOperacao(operacao: String) = repository.findByOperacao(operacao)
}