package app.financeapi.repository.specification

import app.financeapi.entity.Categoria
import org.springframework.data.jpa.domain.Specification


object CategoriaSpec {
	/*
	fun byDescricao(descricao: String): Specification<Categoria> {
		return Specification { root, _, cb -> cb.lower(cb.like(root.get<String>("descricao"), configLike(descricao))) }
	}
	
	private fun configLike(term: String) = if(term == null || term.isEmpty()) "%${term}%" else "%"
	*/
}