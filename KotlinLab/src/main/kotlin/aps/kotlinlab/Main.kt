package aps.kotlinlab

import java.time.LocalDate

fun main(args: Array<String>){
    val start = LocalDate.of(2020, 1, 1)
    val end = LocalDate.of(2020, 1, 10)

    val range = start..end
    val date = LocalDate.of(2020, 11, 5)
    println(date !in range)
}