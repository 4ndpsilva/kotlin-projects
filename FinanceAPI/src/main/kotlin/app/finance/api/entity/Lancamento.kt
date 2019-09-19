package app.finance.api.entity

import app.finance.api.enums.OperacaoEnum

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.JoinColumnOrFormula
import org.hibernate.annotations.JoinColumnsOrFormulas

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "TB_LANCAMENTO")
data class Lancamento(
        @Column(columnDefinition = "DATE")
	val data: LocalDate?,

        @Enumerated(EnumType.STRING)
	val operacao: OperacaoEnum?,

        @Column(length = 20)
	val observacao: String?
) : BaseEntity() {

	@JsonIgnore
	@ManyToOne
	@JoinColumnsOrFormulas(
			JoinColumnOrFormula(name = "categoria_id"),
			JoinColumnOrFormula(name = "usuario_id", insertable = false, updatable = false))
	lateinit var categoria: Categoria

	@JsonIgnore
	@ManyToOne
	@JoinColumnsOrFormulas(
			JoinColumnOrFormula(name = "categoria_id"),
			JoinColumnOrFormula(name = "usuario_id", insertable = false, updatable = false))
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