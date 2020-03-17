package br.com.lotominer.dto

import java.time.LocalDate

data class LotoFacilDTO(
    var contestNumber: String,
    var date: LocalDate,
    var dozens: MutableSet<Int>,
    var accumulatedPrize: Double,
    var numberOfWinners: Int,
    var prize15: Double,
    var prize14: Double
)