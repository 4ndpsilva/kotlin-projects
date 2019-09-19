package app.finance.api.service

import app.finance.api.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(val repository: UsuarioRepository)