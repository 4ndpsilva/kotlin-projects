package aps.judicialagreement.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.persistence.FetchType.EAGER

@Entity
@Table(name = "TB_ACORDO")
data class Agreement(
        @Column(name = "DATA_ACORDO", nullable = false)
        val date: LocalDateTime,

        @Column(name = "DESCRICAO", nullable = false)
        val description: String,

        @Column(name = "VALOR_TOTAL", nullable = false, precision = 6, scale = 2)
        val totalValue: BigDecimal,

        @Column(name = "PARCELAS")
        val plots: Int
) : BaseEntity() {
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    lateinit var customer: Customer

    @ManyToOne
    @JoinColumn(name = "ID_FORMA_PAGAMENTO")
    lateinit var paymentWay: PaymentWay

    @OneToMany(mappedBy = "agreement", cascade = [PERSIST, MERGE, REMOVE])
    val paymentGuideList = mutableListOf<PaymentGuide>()
}