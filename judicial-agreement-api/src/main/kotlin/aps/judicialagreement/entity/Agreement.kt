package aps.judicialagreement.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_ACORDO")
data class Agreement(
        @Column(name = "DATA_ACORDO", nullable = false)
        val date: LocalDateTime,

        @Column(name = "DESCRICAO", nullable = false)
        val description: String,

        @Column(name = "VALOR_TOTAL", nullable = false)
        val totalValue: BigDecimal,

        @Column(name = "PARCELAS")
        val numerOfPlots: Int,
) : BaseEntity() {
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    lateinit var customer: Customer

    @ManyToOne
    @JoinColumn(name = "ID_FORMA_PAGAMENTO")
    lateinit var paymentWay: PaymentWay
}