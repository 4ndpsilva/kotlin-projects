package br.com.lotominer.service

import br.com.lotominer.document.LotoFacil
import br.com.lotominer.util.Constant
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File
import java.lang.Double.parseDouble
import java.time.LocalDate
import java.util.*

object ExtractorService {
    fun extract(): List<LotoFacil> {
        val doc = Jsoup.parse(File(Constant.FILE_NAME), Constant.CHARSET)

        val rows = getTableRows(doc)
        val dataSet = mutableListOf<LotoFacil>()

        for(element in rows) {
            val children = sanitizeElements(element.children())

            val dto = LotoFacil()
            dto.contestNumber = Integer.parseInt(children[0])
            dto.date = LocalDate.parse(children[1], Constant.FORMATTER)

            val dozens = TreeSet<Int>()
            var j = 2
            for(i in 0 until 15){
                val strNumber = children[j]
                dozens.add(Integer.parseInt(strNumber))
                j++
            }

            dto.dozens = dozens

            val lastIndex             = (children.size - 1)
            val index                 = lastIndex - 6
            val indexAccumulatedPrize = lastIndex - 2

            dto.numberOfWinners  = Integer.parseInt(children[18])
            dto.prize15          = toDouble(children[index - 1]);
            dto.prize14          = toDouble(children[index]);
            dto.accumulatedPrize = toDouble(children[indexAccumulatedPrize])
            dataSet.add(dto);
        }

        dataSet.sortBy { it.contestNumber }
        return dataSet;
    }

    private fun getTableRows(doc: Document): List<Element>{
        val elements = doc.getElementsByTag("tr")
        val rows = mutableListOf<Element>()

        for (i in 0 until elements.size) {
            val element = elements[i]
            val children = element.children();

            if (children.isNotEmpty() && children[1].html().trim().matches(Regex(Constant.DATE_PATTERN))) {
                rows.add(element);
            }
        }

        return rows;
    }

    private fun sanitizeElements(elements: Elements): List<String>{
        val children = mutableListOf<String>()
        elements.forEach{ children.add(it.html().replace(Constant.WHITE_SPACE, "")) }
        return children
    }

    private fun toDouble(value: String): Double {
        return parseDouble(value.replace(".", "").replace(",", "."));
    }
}