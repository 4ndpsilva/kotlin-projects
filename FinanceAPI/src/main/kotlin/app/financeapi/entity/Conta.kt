package app.financeapi.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
@Table(name = "TB_CONTA")
data class Conta(
	@Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)
	val descricao: String): BaseEntity<Long>(0L){ 
	
	@ManyToOne
    @JoinColumn(mappedBy = "categoria_id")	
	lateinit var categoria: Categoria
	
	constructor(): this("") 
}