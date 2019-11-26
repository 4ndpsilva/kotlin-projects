package app.smartpoint.api.services

import app.smartpoint.api.documents.Empresa

interface EmpresaService {
    fun findByCnpj(cnpj: String): Empresa?
    fun save(empresa: Empresa): Empresa
}