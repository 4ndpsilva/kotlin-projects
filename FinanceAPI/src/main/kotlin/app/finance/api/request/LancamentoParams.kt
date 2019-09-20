package app.finance.api.request

import app.finance.api.constant.Constants

object LancamentoParams{
    fun parameters(): List<String>{
        return listOf(
                Constants.ID,
                Constants.USUARIO,
                Constants.DATA_INICIO,
                Constants.DATA_FIM,
                Constants.CATEGORIA,
                Constants.CONTA,
                Constants.OPERACAO)
    }
}