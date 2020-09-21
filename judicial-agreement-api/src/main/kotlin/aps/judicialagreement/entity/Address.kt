package aps.judicialagreement.entity

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
data class Address(
        @Column(name = "CEP", length = 10, nullable = false)
        val zipCode: String,

        @Column(name = "LOGRADOURO", length = 100, nullable = false)
        val street: String,

        @Column(name = "NUMERO", length = 5)
        val number: String,

        @Column(name = "BAIRRO", length = 100, nullable = false)
        val district: String, ){

    @ManyToOne
    @JoinColumn(name = "ID_CIDADE")
    lateinit var city: City
}