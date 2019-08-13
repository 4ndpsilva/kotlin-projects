package app.financeapi.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Temporal
import javax.persistence.TemporalType

import java.time.LocalDate

	
@Entity
@Table(name = "TB_CATEGORIA")
data class Categoria(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    @Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)	
	val descricao: String){ constructor(): this(0, "") }


@Entity
@Table(name = "TB_CONTA")
data class Conta(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
	@Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)
	val descricao: String,
	
	@ManyToOne
    @JoinColumn(mappedBy = "categoria_id")	
	val categoria: Categoria?){ constructor(): this(0, "", null) }


@Entity
@Table(name = "TB_LANCAMENTO")
data class Lancamento(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY),
	val id: Long,

	@Temporal(TemporalType.Date) 
	val data: LocalDate, 

	@ManyToOne
    @JoinColumn(mappedBy = "categoria_id")
	val categoria: Categoria, 

	@ManyToOne
    @JoinColumn(mappedBy = "conta_id")	
	val conta: Conta, 

	val valor: Double, 

	@Enumerated(EnumType.STRING)
	val operacao: Operacao){ 
		constructor(): this(0, null, null, null, 0.0, null) 
	}


enum class Operacao(val value: String){
  CREDITO("C"),
  DEBITO("D")
}