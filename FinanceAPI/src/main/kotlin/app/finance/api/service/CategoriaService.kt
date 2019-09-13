package app.finance.api.service

import app.finance.api.entity.Categoria
import app.finance.api.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaService(private val repository: CategoriaRepository) : BaseService<Categoria>(repository)