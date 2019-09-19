package app.finance.api.service

import app.finance.api.entity.BaseEntity
import app.finance.api.repository.BaseRepository

abstract class BaseService<T>(private val repository: BaseRepository<T>) where T : BaseEntity {
    fun save(entity: T) = repository.save(entity)

	fun delete(id: Long): Unit {
		repository.deleteById(id)
	}

	fun exists(id: Long) = repository.existsById(id)
	
	fun findById(id: Long) = repository.findById(id).orElse(null)
	
	open fun find(params: MutableMap<String, Any>? = null): List<T> {
		return repository.findAll()
	}
}