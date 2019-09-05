package app.financeapi.entity

import javax.persistence.MappedSuperclass
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Version


@MappedSuperclass
abstract class BaseEntity<T>(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: T) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as BaseEntity<*>

		if (id != other.id) return false

		return true
	}

	override fun hashCode() = id?.hashCode() ?: 0

	override fun toString() = "BaseEntity(id = $id)"
}