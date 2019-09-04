package app.financeapi.service

import org.springframework.beans.BeanUtils

import app.financeapi.repository.BaseRepository
import app.financeapi.repository.specification.QuerySpec
import app.financeapi.entity.BaseEntity

import app.financeapi.dto.BaseParamsDTO


abstract class BaseService<BaseEntity>(private val repository: BaseRepository<BaseEntity>){
    fun save(entity: BaseEntity) = repository.save(entity)
	
	fun delete(id: Long): Unit{
		repository.deleteById(id)
	}
	
	fun findById(id: Long): BaseEntity = repository.findById(id).orElse(null)
		
	fun find(paramsDTO: BaseParamsDTO? = null) = repository.findAll()
	
	fun exists(id: Long) = repository.existsById(id)
}