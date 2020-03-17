package br.com.lotominer.util

import java.time.format.DateTimeFormatter

object Constant {
    const val URL          = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/D_lotfac.zip"
    const val EXTENSION    = ".HTM"
    const val FILE_NAME    = "lotofacil$EXTENSION"
    const val DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}"
    const val WHITE_SPACE  = "\\s*"
    const val CHARSET      = "UTF-8"
    val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
}