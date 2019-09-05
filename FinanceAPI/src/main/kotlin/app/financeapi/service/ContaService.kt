package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.entity.Conta
import app.financeapi.repository.ContaRepository

@Service
class ContaService(private val repository: ContaRepository) : BaseService<Conta>(repository) {
	fun findByCategoria(idCategoria: Long) = repository.findByCategoriaId(idCategoria)
}