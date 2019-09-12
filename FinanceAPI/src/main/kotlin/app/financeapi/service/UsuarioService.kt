package app.financeapi.service

import org.springframework.stereotype.Service

import app.financeapi.repository.UsuarioRepository
import app.financeapi.entity.Usuario

@Service
class UsuarioService(val repository: UsuarioRepository) : BaseService<Usuario>(repository)