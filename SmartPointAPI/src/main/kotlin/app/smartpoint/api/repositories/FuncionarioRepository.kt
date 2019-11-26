package app.smartpoint.api.repositories

import app.smartpoint.api.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {
    fun findByEmail(email: String): Funcionario
    fun findByCpf(cpf: String): Funcionario
}