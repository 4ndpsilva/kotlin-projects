package app.finance.api.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.JoinColumnOrFormula
import org.hibernate.annotations.JoinColumnsOrFormulas
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Transient


@Entity
@Table(name = "TB_CONTA")
data class Conta(@Column(length = 20, nullable = false) val descricao: String) : BaseEntity() {

    @JsonIgnore
	@ManyToOne
	@JoinColumnsOrFormulas(
			JoinColumnOrFormula(name = "categoria_id"),
			JoinColumnOrFormula(name = "usuario_id", insertable = false, updatable = false))
	lateinit var categoria: Categoria
	
	@Transient
	var idUsuario: Long = 0L
    get() = usuario.id
	
	@Transient
	var idCategoria: Long = 0L
	get() = categoria.id
}