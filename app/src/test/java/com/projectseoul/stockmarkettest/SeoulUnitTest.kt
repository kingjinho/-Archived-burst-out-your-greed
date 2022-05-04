package com.projectseoul.stockmarkettest

import com.projectseoul.stockmarkettest.models.Drawdown
import com.projectseoul.stockmarkettest.models.Quote
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.projectseoul.stockmarkettest.TestData.quotations


import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SeoulUnitTest {

    @Test
    fun addition_isCorrect() {
        val list = findDrawdown()
        assertThat(list.size).isEqualTo(7)
    }


    private fun findDrawdown(): List<Drawdown> {
        val list = mutableListOf<Drawdown>()
        var peak: Quote? = null
        var trough: Quote? = null
        var recovered: Quote? = null

        for (quotation in quotations) {
            val currentIdx = quotations.indexOf(quotation)
            if (currentIdx in 1 until quotations.size - 1) {
                val prevClosing = quotations[currentIdx - 1].price
                val nextClosing = quotations[currentIdx + 1].price
                val closing = quotation.price

                recovered = when {
                    peak == null -> null
                    closing >= peak.price -> {
                        if (peak.date != quotation.date) {
                            //can possibly be new peak
                            Quote(closing, quotation.date)
                        } else null
                    }
                    else -> null
                }

                peak = if (closing > prevClosing && closing > nextClosing) {
                    if ((peak == null || peak.price < closing) && recovered == null) {
                        Quote(closing, quotation.date)
                    } else peak
                } else peak

                trough = if (closing < prevClosing && closing < nextClosing) {
                    if (trough == null || trough.price > closing) {
                        Quote(closing, quotation.date)
                    } else trough
                } else trough


                if (recovered != null) {
                    val drawdown = Drawdown()
                    val percentage = (peak!!.price - trough!!.price) / peak.price
                    if(percentage > 0.1) {
                        drawdown.peak = peak
                        drawdown.trough = trough
                        drawdown.recovered = recovered
                        drawdown.percentage = percentage
                        drawdown.daysToRecover =
                            ChronoUnit.DAYS.between(
                                LocalDate.of(
                                    peak.date.substring(0, 4).toInt(),
                                    peak.date.substring(4, 6).toInt(),
                                    peak.date.substring(6, 8).toInt()
                                ),
                                LocalDate.of(
                                    recovered.date.substring(0, 4).toInt(),
                                    recovered.date.substring(4, 6).toInt(),
                                    recovered.date.substring(6, 8).toInt()
                                ).plusDays(1)
                            ).toString()
                        list += drawdown
                    }
                    peak = if (closing > prevClosing && closing > nextClosing) {
                        Quote(recovered.price, recovered.date)
                    } else {
                        null
                    }
                    trough = null
                    recovered = null
                }
            }
        }
        val drawdown = Drawdown()
        val percentage = (peak!!.price - trough!!.price) / peak.price

        drawdown.peak = peak
        drawdown.trough = trough
        drawdown.recovered = recovered
        drawdown.percentage = percentage
        list += drawdown
        return list
    }

}