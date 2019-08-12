package app.financeapi.entity

import javax.persistence.MappedSuperclass
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@MappedSuperclass
data class BaseEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long)