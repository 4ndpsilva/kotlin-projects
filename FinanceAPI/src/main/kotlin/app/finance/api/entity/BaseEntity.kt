package app.finance.api.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.IdClass
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass

@MappedSuperclass
@IdClass(PK::class)
abstract class BaseEntity{
	var id: Long = 0L

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(mappedBy = "usuario_id", nullable = true)
	lateinit var usuario: Usuario
}