package app.finance.api.request

import app.finance.api.constant.Constants

object ContaParams{
    fun parameters(): List<String>{
        return listOf(Constants.ID, Constants.USUARIO, Constants.CATEGORIA, Constants.DESCRICAO)
    }
}