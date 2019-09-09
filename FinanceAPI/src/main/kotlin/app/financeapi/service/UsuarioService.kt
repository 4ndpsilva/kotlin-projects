package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.entity.Usuario
import app.financeapi.repository.UsuarioRepository

@Service
class UsuarioService(val repo: UsuarioRepository) : BaseService<Usuario>(repo)