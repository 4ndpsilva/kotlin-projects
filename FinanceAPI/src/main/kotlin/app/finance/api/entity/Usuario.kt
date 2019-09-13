package app.finance.api.entity

import javax.persistence.*

@Entity
@Table(name = "TB_USUARIO")
data class Usuario(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = 0L,

    @Column(name = "NOME", length = 50, nullable = false)
	var nome: String? = null, 
	
	@Column(name = "LOGIN", length = 50, unique = true, nullable = false)
	var login: String? = null, 
	
	@Column(name = "SENHA", length = 255, nullable = false)
	var senha: String? = null, 
	
	@Column(name = "ATIVO", nullable = false)
	var ativo: Boolean = true)