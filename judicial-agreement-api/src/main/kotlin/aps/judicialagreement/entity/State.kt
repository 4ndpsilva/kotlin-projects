package aps.judicialagreement.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "TB_ESTADO")
data class State(
        @Column(name = "NOME", length = 100, nullable = false)
        val name: String,

        @Column(name = "SIGLA", length = 2, nullable = false)
        val initials: String
) : BaseEntity()