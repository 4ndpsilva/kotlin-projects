package app.financeapi.service

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import org.springframework.stereotype.Service

import app.financeapi.entity.Lancamento
import app.financeapi.repository.LancamentoRepository

@Service
class LancamentoService(private val repository: LancamentoRepository): BaseService<Lancamento>(repository){
  
    fun listByData(inicio: String, fim: String?): List<Lancamento>{
       val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")	  
  	   val dataInicio = LocalDate.parse(inicio, format) 
	   val dataFim = LocalDate.parse(fim, format) 
	  
	   return repository.findByDataBetween(dataInicio, dataFim)
	}
}