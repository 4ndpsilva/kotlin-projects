package app.financeapi.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column

@Entity
@Table(name = "TB_USUARIO")
data class Usuario(
    @Column(name = "NOME", length = 50, nullable = false)
	var nome: String? = null, 
	
	@Column(name = "LOGIN", length = 50, unique = true, nullable = false)
	var login: String? = null, 
	
	@Column(name = "SENHA", length = 255, nullable = false)
	var senha: String? = null, 
	
	@Column(name = "ATIVO", nullable = false)
	var ativo: Boolean = true): BaseEntity<Long>(0L)