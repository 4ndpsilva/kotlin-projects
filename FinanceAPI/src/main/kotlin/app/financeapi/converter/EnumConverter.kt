package app.financeapi.converter

import javax.persistence.AttributeConverter
import javax.persistence.Converter

import app.financeapi.entity.Operacao

//@Converter(autoApply = true)
class EnumConverter: AttributeConverter<Operacao, String>{
  override fun convertToDatabaseColumn(value: Operacao?): String?{
      return when(value){
	    Operacao.DEBITO -> "D"
		Operacao.CREDITO -> "C"
		else -> null
	  }
  }
  
  override fun convertToEntityAttribute(value: String?): Operacao?{
    return when(value){
	     "D" -> Operacao.DEBITO
		 "C" -> Operacao.CREDITO
		 else -> null
	  }
  }
}