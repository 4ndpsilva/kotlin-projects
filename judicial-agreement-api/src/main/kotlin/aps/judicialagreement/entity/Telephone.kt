package aps.judicialagreement.entity

import javax.persistence.*

@Entity
@Table(name = "TB_TELEFONE")
data class Telephone(
        @Column(length = 3, nullable = false)
        val ddd: String,

        @Column(name = "NUMERO", length = 10, nullable = false)
        val number: String,

        @Column(name = "TIPO", length = 30, nullable = false)
        val type: String,
) : BaseEntity(){

        @ManyToOne
        @JoinColumn(name = "ID_CLIENTE")
        lateinit var customer: Customer
}
