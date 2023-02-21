package com.natersfantasy.piggyrichrpg.util

import java.text.DecimalFormat

fun addCommasToNumber(number: Int?): String {
    val formatter = DecimalFormat("#,###")
    return if (number != null) formatter.format(number) else ""
}