package app.financeapi.entity;

import java.time.LocalDate

data class Usuario(var login: String, var senha: String, var ativo: Boolean)

data class Categoria(var id: Int, var descricao: String)

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