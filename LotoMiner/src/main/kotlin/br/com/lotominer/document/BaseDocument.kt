package br.com.lotominer.document

import org.springframework.data.annotation.Id
import java.time.LocalDate

open class BaseDocument(
    @Id var id: String = "",
    var contestNumber: Int = 0,
    var date: LocalDate = LocalDate.now(),
    var dozens: Set<Int> = mutableSetOf(),
    var accumulatedPrize: Double = 0.0,
    var numberOfWinners: Int = 0
)