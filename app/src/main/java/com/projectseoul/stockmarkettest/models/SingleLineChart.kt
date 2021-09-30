package com.projectseoul.stockmarkettest.models

import android.icu.text.SimpleDateFormat
import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by KING JINHO on 9/28/2021
 */
data class SingleLineChart(
    var xAxisValue: String? = null,
    var xAxis: Int = 0,
    var yAxis: Long = 0
) {
    constructor(xAxis: String,  yAxis: String) : this() {
        val nf = NumberFormat.getInstance(Locale.US)
        this.xAxisValue = xAxis.substring(2)
        this.yAxis = nf.parse(yAxis)!!.toLong()
        this.xAxis = nf.parse(xAxis.replace("/", ""))!!.toInt()
    }

}
