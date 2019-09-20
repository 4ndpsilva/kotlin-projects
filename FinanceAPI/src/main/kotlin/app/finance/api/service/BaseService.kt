package app.finance.api.service

import app.finance.api.entity.BaseEntity
import app.finance.api.entity.PK
import app.finance.api.repository.BaseRepository

abstract class BaseService<T>(private val repository: BaseRepository<T>) where T : BaseEntity {
    fun save(entity: T) = repository.save(entity)

	fun delete(id: PK): Unit {
		repository.deleteById(id)
	}

	fun exists(id: PK) = repository.existsById(id)
	
	fun findById(id: PK) = repository.findById(id).orElse(null)
	
	open fun find(params: MutableMap<String, Any>? = null): List<T> {
		return repository.findAll()
	}
	
	fun generateId(): Long{
		//val e = repository.findTopByOrderByIdAndUsuarioDesc()
		//println("ID: ${e.id}")
		return 0L//e.id
	}
}