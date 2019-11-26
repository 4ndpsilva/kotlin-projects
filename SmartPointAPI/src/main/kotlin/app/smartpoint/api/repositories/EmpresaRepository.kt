package app.smartpoint.api.repositories

import app.smartpoint.api.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String> {
    fun findByCnpj(cnpj: String): Empresa
}