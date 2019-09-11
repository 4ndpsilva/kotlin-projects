package app.financeapi.util

import app.financeapi.constant.Constants


object RequestParametersUtil{	
	fun valid(params: MutableMap<String, Any>): Boolean{
		val list = validParameters()
	    
		for(key in params.keys){
			if(!list.contains(key)){
				return false
			}
		}
		
		return true
	}
	
	private fun validParameters(): List<String>{
		return listOf(
			Constants.ID, 
			Constants.ID_USUARIO, 
			Constants.ID_CATEGORIA, 
			Constants.ID_CONTA, 
			Constants.DATA_INICIO, 
			Constants.DATA_FIM, 
			Constants.DESCRICAO,
			Constants.OPERACAO
		) 
	}
}