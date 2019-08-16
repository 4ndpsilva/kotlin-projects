package app.financeapi.exception

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.annotation.ResponseEntityExceptionHandler

import app.financeapi.dto.ErrorResponseDTO

@RestControllerAdvice
class ExceptionHandlerController: ResponseEntityExceptionHandler(){

  @ExceptionHandler([(value = Exception::class)])
  fun handleExceptionHandler(var ex: Exception, var req: WebRequest): ResponseEntity<ErrorResponseDTO>{
     val error = ErrorResponseDTO()
	 //error.date = LocalDateTime.now()
	 //error.message = ex.getMessage()
	 
	 return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
  }
}