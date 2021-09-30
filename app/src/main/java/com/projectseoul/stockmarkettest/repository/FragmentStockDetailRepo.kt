package com.projectseoul.stockmarkettest.repository

import android.app.Application
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.extensions.execute
import com.projectseoul.stockmarkettest.extensions.getBodyExt
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.utils.Dates.mostCurrentDate
import com.projectseoul.stockmarkettest.utils.Dates.yearAgo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import okhttp3.internal.assertThreadDoesntHoldLock
import okhttp3.internal.toImmutableList
import java.text.NumberFormat
import java.util.*

/**
 * Created by KING JINHO on 9/28/2021
 */
class FragmentStockDetailRepo(application: Application) :
    BaseRepo(application) {

    private var info = mutableListOf<StockBaseInfo>()
    private var quotations = mutableListOf<StockQuotation>()
    private var statement = mutableListOf<StockFinancialStatement>()

    suspend fun getKD(stockCode: String): String? {
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

    suspend fun getStatement(kd: String): HeaderWithStatement {
        if (statement.isNullOrEmpty()) {
            val result = execute { stockMarket.getFinancialStatement(kd) }?.getBodyExt { it }
            if (result != null) {
                statement.add(result)
            }
        }
        return HeaderWithStatement(statement)
    }
}