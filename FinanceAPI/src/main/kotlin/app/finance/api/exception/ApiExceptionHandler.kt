package app.finance.api.exception

import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import java.time.format.DateTimeParseException

@RestControllerAdvice
class ApiExceptionHandler: ResponseEntityExceptionHandler(){
    @ExceptionHandler(ResourceNotFoundException::class)
    fun exception(): ResponseEntity<Any>{
        return ResponseEntity("RECURSO NÃO ENCONTRADO", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(NumberFormatException::class)
    fun handleException() = ResponseEntity("FORMATO INVÁLIDO", HttpStatus.BAD_REQUEST)

    @ExceptionHandler(DateTimeParseException::class)
    fun handleException2() = ResponseEntity("FORMATO DE DATA INVÁLIDO", HttpStatus.BAD_REQUEST)
}