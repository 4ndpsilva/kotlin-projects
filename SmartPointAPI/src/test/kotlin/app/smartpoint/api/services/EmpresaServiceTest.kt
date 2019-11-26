package app.smartpoint.api.services

import app.smartpoint.api.documents.Empresa
import app.smartpoint.api.repositories.EmpresaRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@AutoConfigureDataMongo
@SpringBootTest
class EmpresaServiceTest {
    @Autowired
    private val service: EmpresaService? = null

    @MockBean
    private val repository: EmpresaRepository? = null

    private val CNPJ = "11111111111111"

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(repository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(repository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testFindByCnpj(){
        val e = service?.findByCnpj(CNPJ)
        Assert.assertNotNull(e)
    }

    @Test
    fun testSave(){
        val e = service?.save(empresa())
        Assert.assertNotNull(e)
    }

    private fun empresa() = Empresa( razaoSocial = "Empresa Teste LTDA", id = "1" , cnpj = "11111111111113")
}