package br.com.financeapi.service

import br.com.financeapi.document.Category
import br.com.financeapi.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val repository: CategoryRepository) : BaseService<Category>(repository)