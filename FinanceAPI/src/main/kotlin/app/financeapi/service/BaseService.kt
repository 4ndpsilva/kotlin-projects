package app.financeapi.service

import app.financeapi.repository.BaseRepository

abstract class BaseService<T>(private val repository: BaseRepository<T>){
    fun save(entity: T) = repository.save(entity)
	
	fun delete(id: Long): Unit{
		repository.deleteById(id)
	}
	
	fun findById(id: Long): T = repository.findById(id).orElse(null)
		
	fun findAll(): List<T> = repository.findAll()
}
