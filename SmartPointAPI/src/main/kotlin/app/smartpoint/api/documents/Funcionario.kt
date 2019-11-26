package app.smartpoint.api.documents

import app.smartpoint.api.enums.PerfilEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Funcionario(
        @Id val id: String? = null,
        val nome: String,
        val cpf: String,
        val email: String,
        val senha: String,
        val perfil: PerfilEnum,
        val empresaId: String,
        val valorHora: Double? = 0.0,
        val qtdHorasTrabalhadasDia: Double? = 0.0,
        val qtdHorasAlmoco: Double? = 0.0
)