package app.smartpoint.api.services

import app.smartpoint.api.documents.Funcionario

interface FuncionarioService {
    fun save(funcionario: Funcionario): Funcionario
    fun buscarPorCpf(cpf: String): Funcionario?
    fun buscarPorEmail(email: String): Funcionario?
    fun buscarPorId(id: String): Funcionario?
}