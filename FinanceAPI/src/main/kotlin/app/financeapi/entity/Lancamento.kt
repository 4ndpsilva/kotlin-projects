package app.financeapi.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.EnumType
import javax.persistence.Enumerated

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

	@ManyToOne
	@JoinColumn(mappedBy = "categoria_id", nullable = false)
	lateinit var categoria: Categoria

	@ManyToOne
	@JoinColumn(mappedBy = "conta_id", nullable = false)
	lateinit var conta: Conta

	@Column(precision = 5, scale = 2, nullable = false)
	var valor: Double = 0.0
}