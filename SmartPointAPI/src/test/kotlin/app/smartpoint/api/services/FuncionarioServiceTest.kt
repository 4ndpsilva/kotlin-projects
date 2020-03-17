package app.smartpoint.api.services

import app.smartpoint.api.documents.Funcionario
import app.smartpoint.api.enums.PerfilEnum
import app.smartpoint.api.repositories.FuncionarioRepository
import app.smartpoint.api.utils.PasswordUtils
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {
    @MockBean
    private val repo: FuncionarioRepository? = null

    @Autowired
    private val service: FuncionarioService? = null

    private val email = "email@provider.com"
    private val cpf = "11111111111"
    private val id = "1"

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(repo?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
        BDDMockito.given(repo?.findByEmail(email)).willReturn(funcionario())
        BDDMockito.given(repo?.findByCpf(cpf)).willReturn(funcionario())
        BDDMockito.given(repo?.findById(id)?.get()).willReturn(funcionario())
    }

    fun testSaveFuncionario(){
        var func = service?.save(funcionario())
        Assert.assertNotNull(func)
    }

    private fun funcionario(): Funcionario{
        return Funcionario(
                nome ="funcionario teste",
                cpf = cpf,
                email = email,
                senha = PasswordUtils.getBcrypt("1234"),
                perfil = PerfilEnum.ROLE_USUARIO,
                empresaId = id)
    }
}