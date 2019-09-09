package app.financeapi.repository

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

import app.financeapi.entity.Usuario

@Repository
interface UsuarioRepository : BaseRepository<Usuario> {}