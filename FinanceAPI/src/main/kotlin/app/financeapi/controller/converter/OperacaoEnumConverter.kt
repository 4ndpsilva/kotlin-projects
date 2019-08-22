package app.financeapi.controller.converter

import java.beans.PropertyEditorSupport
import app.financeapi.entity.Operacao

class OperacaoEnumConverter: PropertyEditorSupport{
  constructor()
  
  override fun setAsText(text: String){
	setValue(enumValueOf<Operacao>(text.toUpperCase()) ?: throw IllegalArgumentException())
  }
}