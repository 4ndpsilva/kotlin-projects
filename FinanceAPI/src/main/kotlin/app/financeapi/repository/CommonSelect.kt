package app.financeapi.repository

import app.financeapi.entity.BaseEntity

interface CommonSelect<T> where T : BaseEntity<Long> {
	fun findByUsuarioId(idUsuario: Long): List<T>
}