package app.financeapi.exception

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.bind.annotarion.RestControllerAdevice
import org.springframework.web.bind.annotarion.ExceptionHandler
import org.springframework.web.servlet.mvc.annotarion.ResponseEntityExceptionHandler

import app.financeapi.dto.ErrorResponseDTO

@RestControllerAdevice
class ExceptionHandlerController: ResponseEntityExceptionHandler(){

  @ExceptionHandler([(value = Exception::class)])
  fun handleExceptionHandler(ex: Exception, req: WebRequest): ResponseEntity<ErrorResponseDTO>{
     val error = ErrorResponseDTO()
	 error.date = LocalDateTime.now()
	 error.message = ex.getMessage()
	 
	 return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
  }
}