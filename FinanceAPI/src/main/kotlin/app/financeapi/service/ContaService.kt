package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.entity.Conta
import app.financeapi.repository.ContaRepository

@Service
class ContaService(private val repository: ContaRepository){
    fun save(entity: Conta) = repository.save(entity)
	
	fun delete(id: Long): Unit{
		repository.deleteById(id)
	}
	
	fun findById(id: Long): Conta{
		val entity = repository.findById(id).orElse(null)
		return entity
	}
	
	fun list(): List<Conta> = repository.findAll()
}