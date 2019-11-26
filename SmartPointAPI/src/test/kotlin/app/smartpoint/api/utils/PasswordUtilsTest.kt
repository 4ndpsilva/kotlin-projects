package app.smartpoint.api.utils

import org.junit.Assert
import org.junit.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PasswordUtilsTest {
    private val SENHA = "123456"
    private val bCrypt = BCryptPasswordEncoder()

    @Test
    fun testGeneratePassword(){
        val hash = PasswordUtils.getBcrypt(SENHA)
        Assert.assertTrue(bCrypt.matches(SENHA, hash))
    }
}