package app.financeapi.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateUtil {
	private constructor()

	companion object {
		fun toLocalDate(str: String, format: String) = LocalDate.parse(str, DateTimeFormatter.ofPattern(format))
	}
}