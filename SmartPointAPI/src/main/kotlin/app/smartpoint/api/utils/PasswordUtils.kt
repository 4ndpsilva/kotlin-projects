package app.smartpoint.api.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object PasswordUtils {
    fun getBcrypt(passwd: String) = BCryptPasswordEncoder().encode(passwd)
}