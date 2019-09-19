package app.finance.api.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Transient


@Entity
@Table(name = "TB_CATEGORIA")
data class Categoria(@Column(length = 20, unique = true, nullable = false) val descricao: String) : BaseEntity(){

	@Transient
	var idUsuario: Long? = 0L
    get() = usuario.id
}