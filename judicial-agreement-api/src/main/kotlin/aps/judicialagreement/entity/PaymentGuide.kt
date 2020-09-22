package aps.judicialagreement.entity

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "TB_GUIA_PAGAMENTO")
data class PaymentGuide(
        @Column(name = "NUMERO_PARCELA", nullable = false)
        var numberOfPlot: Int = 0,

        @Column(name = "DATA_VENCIMENTO", nullable = false)
        var dueDate: LocalDate = LocalDate.now(),

        @Column(name = "DATA_PAGAMENTO")
        var payday: LocalDate? = null,

        @Column(name = "VALOR", precision = 6, scale = 2, nullable = false)
        var value: BigDecimal = BigDecimal.ZERO,

        @Column(name = "QUITADO", nullable = false)
        var settled: Boolean = false,
) : BaseEntity() {
    @ManyToOne
    @JoinColumn(name = "ID_ACORDO")
    lateinit var agreement: Agreement
}