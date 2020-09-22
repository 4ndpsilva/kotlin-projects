package aps.judicialagreement.entity

import java.time.LocalDate
import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.persistence.FetchType.EAGER

@Entity
@Table(name = "TB_CLIENTE")
data class Customer(
        @Column(name = "NOME", length = 100, nullable = false)
        val name: String,

        @Column(name = "DATA_NASCIMENTO",  nullable = false)
        val dateOfBirth: LocalDate,

        @Column(name = "CPF", length = 11, nullable = false)
        val cpf: String,

        @Column(name = "EMAIL", length = 100, nullable = false)
        val email: String,
) : BaseEntity(){
        @OneToMany(mappedBy = "customer", cascade = [PERSIST, MERGE, REMOVE], fetch = EAGER)
        lateinit var telephones: MutableList<Telephone>

        @Embedded
        lateinit var address: Address
}