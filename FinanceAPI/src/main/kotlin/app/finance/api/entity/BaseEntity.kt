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
	@Id var id: Long = 0L

	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(mappedBy = "usuario_id", nullable = true)
	lateinit var usuario: Usuario

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as BaseEntity

		if (id != other.id) return false

		return true
	}

	override fun hashCode() = id.hashCode()

	override fun toString() = "BaseEntity(id = $id)"
}