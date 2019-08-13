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
import javax.persistence.Convert

import java.time.LocalDate

import app.financeapi.converter.EnumConverter

	
@Entity
@Table(name = "TB_CATEGORIA")
data class Categoria(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	val id: Long,
    @Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)	
	val descricao: String){ constructor(): this(0, "") }


@Entity
@Table(name = "TB_CONTA")
data class Conta(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	val id: Long,
	@Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)
	val descricao: String,
	
	@ManyToOne
    @JoinColumn(mappedBy = "categoria_id")	
	val categoria: Categoria?){ constructor(): this(0, "", null) }


@Entity
@Table(name = "TB_LANCAMENTO")
data class Lancamento(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long,

	@Column(columnDefinition = "DATE")
	val data: LocalDate?, 
	
	@ManyToOne
    @JoinColumn(mappedBy = "categoria_id", nullable = false)
	val categoria: Categoria?, 

	@ManyToOne
    @JoinColumn(mappedBy = "conta_id", nullable = false)	
	val conta: Conta?, 
	
	@Column(precision = 5, scale = 2, nullable = false)
	val valor: Double?, 

	@Enumerated//(EnumType.STRING)
	//@Convert(converter = EnumConverter::class)
	val operacao: Operacao?, 
	
	@Column(length = 20)
	val observacao: String?){ 
		constructor(): this(0, null, null, null, null, null, null) 
	}


enum class Operacao{
  CREDITO
  DEBITO
}