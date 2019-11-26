package app.smartpoint.api.documents

import app.smartpoint.api.enums.TipoLancamentoEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
data class Lancamento(
        @Id val id: String? = null,
        val data: LocalDate,
        val tipo: TipoLancamentoEnum,
        val funcionarioId: String,
        val descricao: String? = null,
        val localizacao: String? = null
)