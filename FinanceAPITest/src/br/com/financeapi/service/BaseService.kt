package br.com.financeapi.service

import br.com.financeapi.document.BaseDocument
import br.com.financeapi.repository.BaseRepository

open class BaseService<T : BaseDocument>(private var repository: BaseRepository<T>){
    fun save(document: T) = repository.save(document)

    fun delete(id: String) = repository.deleteById(id)

    fun exists(id: String) = repository.existsById(id)

    fun findById(id: String) = repository.findById(id).orElse(null)

    open fun find(params: MutableMap<String, Any>? = null): List<T> {
        return repository.findAll()
    }
}