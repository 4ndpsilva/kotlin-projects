package aps.judicialagreement.entity

import javax.persistence.*

@Entity
@Table(name = "TB_CIDADE")
data class City(
        @Column(name = "NOME", length = 100, nullable = false)
        val name: String,

        @ManyToOne
        @JoinColumn(name = "ID_ESTADO", nullable = false)
        val state: State
) : BaseEntity()