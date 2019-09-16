package app.finance.api.request

import app.finance.api.constant.Constants

object LancamentoParams{
    fun parameters(): List<String>{
        return listOf(
                Constants.ID,
                Constants.DATA_INICIO,
                Constants.DATA_FIM,
                Constants.ID_CATEGORIA,
                Constants.ID_CONTA,
                Constants.OPERACAO)
    }
}