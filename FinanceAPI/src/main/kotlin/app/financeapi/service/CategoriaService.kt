package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.entity.Categoria
import app.financeapi.repository.CategoriaRepository

@Service
class CategoriaService(private val repository: CategoriaRepository){
    fun save(entity: Categoria) = repository.save(entity)
	
	fun delete(id: Long): Unit{
		repository.deleteById(id)
	}
	
	fun findById(id: Long): Categoria{
		val entity = repository.findById(id).orElse(null)
		return entity
	}
	
	fun list(): List<Categoria> = repository.findAll()
}