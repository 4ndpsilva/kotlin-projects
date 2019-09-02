package app.financeapi.service

import org.springframework.beans.BeanUtils

import app.financeapi.repository.BaseRepository
import app.financeapi.entity.BaseEntity


abstract class BaseService<BaseEntity>(private val repository: BaseRepository<BaseEntity>){
    fun save(entity: BaseEntity) = repository.save(entity)
	
	fun delete(id: Long): Unit{
		repository.deleteById(id)
	}
	
	fun findById(id: Long): BaseEntity = repository.findById(id).orElse(null)
		
	fun findAll(): List<BaseEntity> = repository.findAll()
	
	fun exists(id: Long) = repository.existsById(id)
}