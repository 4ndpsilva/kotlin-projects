package app.finance.api.request

object RequestParametersValidator{
	fun valid(validParams: List<String>, params: MutableMap<String, Any>): Boolean{
		if(!validParams.isEmpty()){
			params.keys.forEach{
				if(!validParams.contains(it)){
					return false
				}
			}
		}

		return true
	}
}