package app.finance.api.entity

import app.finance.api.enums.OperacaoEnum
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Transient

import com.fasterxml.jackson.annotation.JsonIgnore

import java.time.LocalDate

@Entity
@Table(name = "TB_LANCAMENTO")
data class Lancamento(
        @Column(columnDefinition = "DATE")
	val data: LocalDate?,

        @Enumerated(EnumType.STRING)
	val operacao: OperacaoEnum?,

        @Column(length = 20)
	val observacao: String?
) : BaseEntity<Long>(0L) {

    @JsonIgnore 
    @ManyToOne
	@JoinColumn(mappedBy = "usuario_id", nullable = true)
	lateinit var usuario: Usuario 
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(mappedBy = "categoria_id", nullable = false)
	lateinit var categoria: Categoria

	@JsonIgnore
	@ManyToOne
	@JoinColumn(mappedBy = "conta_id", nullable = false)
	lateinit var conta: Conta

	@Column(precision = 5, scale = 2, nullable = false)
	var valor: Double = 0.0
	
	@Transient
	var idUsuario: Long? = 0L
    get() = usuario.id
	
	@Transient
	var idCategoria: Long? = 0L
	get() = categoria.id
	
	@Transient
	var idConta: Long? = 0L
	get() = conta.id
}