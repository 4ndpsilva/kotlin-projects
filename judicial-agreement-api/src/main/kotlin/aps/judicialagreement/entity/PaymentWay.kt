package aps.judicialagreement.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "TB_FORMA_PAGAMENTO")
data class PaymentWay(
        @Column(name = "DESCRICAO", length = 100, nullable = false)
        val description: String
) : BaseEntity()