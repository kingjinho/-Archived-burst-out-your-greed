package com.projectseoul.stockmarkettest.models

/**
 * Created by KING JINHO on 11/29/2021
 */
class Drawdown {
    var peak: Quote? = null
    var trough: Quote? = null
    var recovered: Quote? = null
    var rangeInPercentage: Double? = null
    var daysToRecover: String? = null
}

data class Quote(
    val price: Double,
    val date: String
)
