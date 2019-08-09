package app.financeapi.entity;

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

import java.time.LocalDate

data class Usuario(var login: String, var senha: String, var ativo: Boolean)

@Entity
@Table(name = "TB_CATEGORIA")
data class Categoria(
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = 0L, 
	var descricao: String)

data class Conta(var id: Int, var descricao: String, var categoria: Categoria)

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