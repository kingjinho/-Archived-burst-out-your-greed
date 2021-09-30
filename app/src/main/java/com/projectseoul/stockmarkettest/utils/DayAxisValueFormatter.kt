package com.projectseoul.stockmarkettest.utils

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.formatter.ValueFormatter

/**
 * Created by KING JINHO on 9/29/2021
 */
class DayAxisValueFormatter(private val char: LineChart): ValueFormatter() {

    override fun getFormattedValue(value: Float): String {
        val newValue = value.toInt().toString()
        return try{
            "${newValue.substring(2,4)}/${newValue.substring(4,6)}/${newValue.substring(6,8)}"
        } catch (ex: Exception) {
            "00/00/00"
        }
    }
}