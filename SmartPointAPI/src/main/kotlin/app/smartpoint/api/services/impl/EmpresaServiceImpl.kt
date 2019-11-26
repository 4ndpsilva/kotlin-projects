package app.smartpoint.api.services.impl

import app.smartpoint.api.documents.Empresa
import app.smartpoint.api.repositories.EmpresaRepository
import app.smartpoint.api.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val repo: EmpresaRepository) : EmpresaService{
    override fun findByCnpj(cnpj: String) = repo.findByCnpj(cnpj)
    override fun save(empresa: Empresa) = repo.save(empresa)
}