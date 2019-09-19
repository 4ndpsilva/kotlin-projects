package app.finance.api.request

import app.finance.api.constant.Constants

object CategoriaParams{
    fun parameters(): List<String>{
        return listOf(Constants.ID, Constants.ID_USUARIO, Constants.DESCRICAO)
    }
}
