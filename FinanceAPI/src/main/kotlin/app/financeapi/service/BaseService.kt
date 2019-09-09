package app.financeapi.service

import app.financeapi.repository.BaseRepository
import app.financeapi.entity.BaseEntity
import app.financeapi.dto.BaseParamsDTO


abstract class BaseService<BaseEntity>(private val repository: BaseRepository<BaseEntity>) {
	fun save(entity: BaseEntity) = repository.save(entity)

	fun delete(id: Long): Unit {
		repository.deleteById(id)
	}

	fun findById(id: Long) = repository.findById(id).orElse(null)
	
	fun find(paramsDTO: BaseParamsDTO? = null) = repository.findAll()
	
	fun findByFilter(filter: Map<String, Any>? = null): List<BaseEntity> {
	  return mutableListOf<BaseEntity>()
	}

	fun exists(id: Long) = repository.existsById(id)
}