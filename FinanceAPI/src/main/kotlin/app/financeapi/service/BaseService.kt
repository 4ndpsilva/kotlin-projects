package app.financeapi.service

import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.BaseRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.BaseEntity


abstract class BaseService<T>(private val repository: BaseRepository<T>) where T : BaseEntity<Long> {
	fun save(entity: T) = repository.save(entity)

	fun delete(id: Long): Unit {
		repository.deleteById(id)
	}

	fun exists(id: Long) = repository.existsById(id)
	
	fun findById(id: Long) = repository.findById(id).orElse(null)
	
	open fun find(params: MutableMap<String, Any>? = null): List<T> {
	  var spec = Specification.where<T>(null)
	  
	  if(params != null){
	    if(params.get("id") != null){
		  spec = spec.and(QuerySpec.byId<T>(params.get("id") as Long))
		}
		if(params.get("descricao") != null){
		  spec = spec.and(QuerySpec.byLike<T>(params.get("descricao").toString()))
		}
	  }
	  	  
	  return repository.findAll(spec)
	}
}