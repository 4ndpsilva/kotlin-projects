package app.financeapi.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Transient

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "TB_CONTA")
data class Conta(
	@Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)
	val descricao: String
) : BaseEntity<Long>(0L) {
    
	@JsonIgnore
    @ManyToOne
	@JoinColumn(mappedBy = "usuario_id", nullable = true)
	lateinit var usuario: Usuario
  
    @JsonIgnore
	@ManyToOne
	@JoinColumn(mappedBy = "categoria_id")
	lateinit var categoria: Categoria
	
	@Transient
	var idUsuario: Long? = 0L
    get() = usuario.id
	
	@Transient
	var idCategoria: Long? = 0L
	get() = categoria.id
}