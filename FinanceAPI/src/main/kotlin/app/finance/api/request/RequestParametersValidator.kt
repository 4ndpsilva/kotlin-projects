package app.finance.api.request

object RequestParametersValidator{
	fun valid(validParams: List<String>? = null, params: MutableMap<String, Any>): Boolean{
		if(validParams != null && !validParams.isEmpty()){
			for(key in params.keys){
				if(!validParams.contains(key)){
					return false
				}
			}
		}

		return true
	}
}