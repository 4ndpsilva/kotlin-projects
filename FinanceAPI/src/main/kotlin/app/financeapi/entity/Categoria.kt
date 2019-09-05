package app.financeapi.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column


@Entity
@Table(name = "TB_CATEGORIA")
data class Categoria(
	@Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)
	val descricao: String
) : BaseEntity<Long>(0L)