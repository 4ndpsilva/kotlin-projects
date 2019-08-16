package app.financeapi.dto

import java.time.LocalDateTime

data class ErrorResponseDTO(){
  constructor(val code: Int?, val message: String?, val date: LocalDateTime?): this()
}