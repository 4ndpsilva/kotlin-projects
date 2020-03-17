package br.com.lotominer.dto

import java.math.BigDecimal

data class TotalizerDTO(
        var highestPrize15: BigDecimal = BigDecimal.ZERO,
        var lowestPrize15: BigDecimal = BigDecimal.ZERO,
        var highestPrize14: BigDecimal = BigDecimal.ZERO,
        var lowestPrize14: BigDecimal = BigDecimal.ZERO,
        var highestCumulativeValue: BigDecimal = BigDecimal.ZERO,
        var lowestCumulativeValue: BigDecimal = BigDecimal.ZERO,
        var totalCumulativeTimes: Int = 0,
        var totalContests: Int = 0
)