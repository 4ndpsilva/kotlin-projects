package app.financeapi.service

import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.BaseRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.BaseEntity
import app.financeapi.constant.Constants


abstract class BaseService<T>(private val repository: BaseRepository<T>) where T : BaseEntity<Long> {
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