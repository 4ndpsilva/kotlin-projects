package app.financeapi.entity

import javax.persistence.MappedSuperclass
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

import java.time.LocalDate

/*
@MappedSuperclass
data class BaseEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null)
*/
	
@Entity
@Table(name = "TB_CATEGORIA")
data class Categoria(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    @Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)	
	val descricao: String){ constructor(): this(0, "") }

@Entity
@Table(name = "TB_CONTA")
data class Conta(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
	@Column(name = "DESCRICAO", length = 20, unique = true, nullable = false)
	var descricao: String,
	@ManyToOne
    @JoinColumn(mappedBy = "categoria_id")	
	var categoria: Categoria?){ constructor(): this(0, "", null) }

data class Lancamento(var id: Int, 
					  var data: LocalDate, 
					  var categoria: Categoria, 
					  var conta: Conta, 
					  var valor: Double, 
					  var operacao: String)

enum class Operacao(val value: String){
  CREDITO("C"),
  DEBITO("D")
}