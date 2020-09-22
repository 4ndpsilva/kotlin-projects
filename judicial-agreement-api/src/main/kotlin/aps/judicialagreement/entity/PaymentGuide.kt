package aps.judicialagreement.entity

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "TB_GUIA_PAGAMENTO")
data class PaymentGuide(
        @Column(name = "NUMERO_PARCELA", nullable = false)
        val numberOfPlot: Int,

        @Column(name = "DATA_VENCIMENTO", nullable = false)
        val dueDate: LocalDate,

        @Column(name = "DATA_PAGAMENTO")
        val payday: LocalDate,

        @Column(name = "VALOR", precision = 6, scale = 2, nullable = false)
        val value: BigDecimal,

        @Column(name = "QUITADO", nullable = false)
        val settled: Boolean,
) : BaseEntity() {
    @ManyToOne
    @JoinColumn(name = "ID_ACORDO")
    lateinit var agreement: Agreement
}