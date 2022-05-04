package com.projectseoul.stockmarkettest.repository

import android.app.Application
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.utils.execute
import com.projectseoul.stockmarkettest.extensions.getBodyExt
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.utils.Dates.mostCurrentDate
import com.projectseoul.stockmarkettest.utils.Dates.yearAgo
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Created by KING JINHO on 9/28/2021
 */
class FragmentStockDetailRepo(application: Application) :
    BaseRepo(application) {

    private var info = mutableListOf<StockBaseInfo>()
    private var quotations = mutableListOf<StockQuotation>()
    private var statement = mutableListOf<StockFinancialStatement>()

    fun getKD(stockCode: String): String? {
        return db.stockDao().getKD(stockCode)
    }

    suspend fun getBaseInfo(kd: String): HeaderWithBasicInfo {
        if (info.isNullOrEmpty()) {
            val result = execute {
                stockMarket.getStockBaseInfo(kd)
            }?.getBodyExt { it }

            if (result != null) {
                info.add(result)
            }
        }
        return HeaderWithBasicInfo(info)
    }


    suspend fun getQuotationHistory(kd: String): List<HeaderWithSingleLineChart> {
        if (quotations.isNullOrEmpty()) {
            val async = execute { stockMarket.getQuotationHistory(kd, yearAgo, mostCurrentDate) }
            val result = async?.getBodyExt { it?.result } ?: emptyList()
            quotations += result
        }

        val list = mutableListOf<HeaderWithSingleLineChart>()
        list += quotations.map {
            SingleLineChart(it.date, it.closing)
        }.run {
            HeaderWithSingleLineChart(R.string.stock_detail_closing_price_quotation, listOf(this))
        }
        list += quotations.map {
            SingleLineChart(it.date, it.volume)
        }.run {
            HeaderWithSingleLineChart(R.string.stock_detail_volume_quotation, listOf(this))
        }
        list += quotations.map {
            SingleLineChart(it.date, it.amount)
        }.run {
            HeaderWithSingleLineChart(R.string.stock_detail_amount_quotation, listOf(this))
        }
        list += quotations.map {
            SingleLineChart(it.date, it.marketCap)
        }.run {
            HeaderWithSingleLineChart(R.string.stock_detail_market_cap_quotation, listOf(this))
        }
        return list
    }

    suspend fun getDrawdowns(kd: String): List<Drawdown> {
        if (quotations.isNullOrEmpty()) {
            val async = execute { stockMarket.getQuotationHistory(kd, yearAgo, mostCurrentDate) }
            val result = async?.getBodyExt { it?.result } ?: emptyList()
            quotations += result
        }
        val drawdownList = calculateDrawdowns()
        return drawdownList
    }

    suspend fun getStatement(kd: String): HeaderWithStatement {
        if (statement.isNullOrEmpty()) {
            val result = execute { stockMarket.getFinancialStatement(kd) }?.getBodyExt { it }
            if (result != null) {
                statement.add(result)
            }
        }
        return HeaderWithStatement(statement)
    }

    /**
     * Definition of Drawdowns
     *  1. peak to trough decline within a specific period of time
     *  2. recorded when a old peak has recovered
     *
     * more than 10% drops,
     * has recovered
     */
    private fun calculateDrawdowns(): List<Drawdown> {
        val list = mutableListOf<Drawdown>()
        var peak: Quote? = null
        var trough: Quote? = null
        var recovered: Quote? = null

        for (quotation in quotations) {
            val currentIdx = quotations.indexOf(quotation)
            if (currentIdx in 1 until quotations.size - 1) {
                val prevClosing = quotations[currentIdx - 1].closing.toDouble()
                val nextClosing = quotations[currentIdx + 1].closing.toDouble()
                val closing = quotation.closing.toDouble()

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
                    if (percentage >= 0.1) {
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