package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.entity.Categoria
import app.financeapi.repository.CategoriaRepository

@Service
class CategoriaService(private val repository: CategoriaRepository) : BaseService<Categoria>(repository)