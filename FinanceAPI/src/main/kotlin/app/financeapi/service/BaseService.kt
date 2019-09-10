package app.financeapi.service

import org.springframework.data.jpa.domain.Specification

import app.financeapi.repository.BaseRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.BaseEntity
import app.financeapi.constant.Constants


abstract class BaseService<T>(private val repository: BaseRepository<T>) where T : BaseEntity<Long> {
    protected var spec = Specification.where<T>(null)
	
	fun save(entity: T) = repository.save(entity)

	fun delete(id: Long): Unit {
		repository.deleteById(id)
	}

	fun exists(id: Long) = repository.existsById(id)
	
	fun findById(id: Long) = repository.findById(id).orElse(null)
	
	open fun find(params: MutableMap<String, Any>?): List<T> {
	  params?.let{	  
		  if(params.contains(Constants.ID)){
			spec = spec.and(QuerySpec.byId<T>(params.get(Constants.ID).toString().toLong()))
		  }
		  if(params.contains(Constants.DESCRICAO)){
			spec = spec.and(QuerySpec.byLike<T>(params.get(Constants.DESCRICAO).toString()))
		  }
	  }
	  
	  return repository.findAll(spec)
	}
}