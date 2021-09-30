package com.projectseoul.stockmarkettest.utils

import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.DecimalFormat

/**
 * Created by KING JINHO on 9/29/2021
 */
class YAxisValueFormatter() : ValueFormatter() {

    private val format = DecimalFormat("#,###")

    override fun getFormattedValue(value: Float): String {
        return format.format(value)
    }
}