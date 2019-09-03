package app.financeapi.service

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.springframework.stereotype.Service
import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.LancamentoRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.Lancamento
import app.financeapi.entity.Operacao


@Service
class LancamentoService(private val repository: LancamentoRepository): BaseService<Lancamento>(repository){
  
    fun findByData(inicio: String, fim: String): List<Lancamento>{
       val format = DateTimeFormatter.ofPattern("dd-MM-yyyy")	  
  	   val dataInicio = LocalDate.parse(inicio, format) 
	   val dataFim = LocalDate.parse(fim, format) 
	  
	   return repository.findByDataBetweenOrderByDataDesc(dataInicio, dataFim)
	}
	
	fun findByCategoria(idCategoria: Long) = repository.findByCategoriaId(idCategoria)
    
	fun findByConta(idConta: Long) = repository.findByContaId(idConta)
    
	fun findByOperacao(operacao: Operacao) = repository.findByOperacao(operacao)
	
	fun find(inicio: String, fim: String): List<Lancamento> {
	  val format = DateTimeFormatter.ofPattern("dd-MM-yyyy")	  
  	  val dataInicio = LocalDate.parse(inicio, format) 
	  val dataFim = LocalDate.parse(fim, format) 
	   
	  return repository.findAll(Specification.where(QuerySpec.between(dataInicio, dataFim)))
	}  
}