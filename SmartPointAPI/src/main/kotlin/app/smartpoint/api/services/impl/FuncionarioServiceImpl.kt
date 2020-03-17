package app.smartpoint.api.services.impl

import app.smartpoint.api.documents.Funcionario
import app.smartpoint.api.repositories.FuncionarioRepository
import app.smartpoint.api.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val repo: FuncionarioRepository) : FuncionarioService{

    override fun save(funcionario: Funcionario): Funcionario {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buscarPorCpf(cpf: String): Funcionario? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buscarPorEmail(email: String): Funcionario? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buscarPorId(id: String): Funcionario? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}