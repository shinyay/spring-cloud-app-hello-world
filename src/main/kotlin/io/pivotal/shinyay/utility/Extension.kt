package io.pivotal.shinyay.utility

private val daysLookuo = (1..31).associate { it.toLong() to getOrdinal(it) }

private fun getOrdinal(n: Int) = when {
    n in 11..13 -> "${n}th"
    n % 10 == 1 -> "${n}st"
    n % 10 == 2 -> "${n}nd"
    n % 10 == 3 -> "${n}rd"
    else -> "${n}th"
}