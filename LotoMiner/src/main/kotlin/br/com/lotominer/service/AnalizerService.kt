package br.com.lotominer.service

import br.com.lotominer.document.LotoFacil
import br.com.lotominer.dto.TotalizerDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class AnalizerService(val service: LotoFacilService, var dataSet: List<LotoFacil> = emptyList()) {
    fun compute(): TotalizerDTO {
        dataSet = service.findAll()

        if(dataSet.isEmpty()) {
            dataSet = ExtractorService.extract()
            dataSet = service.save(dataSet)
        }

        return computeResults()
    }

    fun getTotalContests() = dataSet.size

    fun findRepeated(list: List<LotoFacil>): List<LotoFacil> {
        val repeatedGames = mutableListOf<LotoFacil>()
        val dozens = mutableSetOf<String>()

        for (dto in list) {
            val sb = StringBuilder()
            dto.dozens.forEach{ sb.append("$it ") }

            val added = dozens.add(sb.toString().trim())
            if (!added) {
                repeatedGames.add(dto);
            }
        }

        return repeatedGames;
    }

    fun frequencyNumbers(list: List<LotoFacil>, totalNumbers: Int): Map<Int, Int>{
        val frequencies = TreeMap<Int, Int>()

        for (number in 1..totalNumbers) {
            var frequency = 0

            for (contest in dataSet) {
                val dozens = contest.dozens
                if (dozens.contains(number)) {
                    frequency++
                }
            }

            frequencies[number] = frequency
        }

        return frequencies;
    }

    fun generateRandomSequence(quantity: Int, length: Int, totalNumbers: Int): Map<Int, Set<Int>>{
        val mapDozens = mutableMapOf<Int, Set<Int>>()
        val random = Random()

        for (i in 0 until quantity) {
            val dozens = TreeSet<Int>();

            do{
                dozens.add(random.nextInt(totalNumbers) + 1);
            }
            while(dozens.size < length)

            mapDozens[i + 1] = dozens
        }

        return mapDozens
    }

    fun computeResults(): TotalizerDTO {
        val filter15 = dataSet.filter{ x -> x.prize15 > 0 }
        val filter14 = dataSet.filter{x -> x.prize14 > 0}
        val filterAccumulated = dataSet.filter{ x -> x.accumulatedPrize > 0 }

        val dto = TotalizerDTO()
        dto.highestPrize15 = BigDecimal(filter15.maxBy{ it.prize15 }?.prize15 ?: 0.0)
        dto.lowestPrize15 = BigDecimal(filter15.minBy{ it.prize15 }?.prize15 ?: 0.0)
        dto.highestPrize14 = BigDecimal(filter14.maxBy{ it.prize14 }?.prize14 ?: 0.0)
        dto.lowestPrize14 = BigDecimal(filter14.minBy{ it.prize14 }?.prize14 ?: 0.0)
        dto.highestCumulativeValue = BigDecimal(filterAccumulated.maxBy{ it.accumulatedPrize }?.accumulatedPrize ?: 0.0)
        dto.lowestCumulativeValue = BigDecimal(filterAccumulated.minBy{ it.accumulatedPrize }?.accumulatedPrize ?: 0.0)
        dto.totalCumulativeTimes = filterAccumulated.size
        dto.totalContests = dataSet.size
        return dto;
    }
}