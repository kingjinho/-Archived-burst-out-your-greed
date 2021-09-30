package com.projectseoul.stockmarkettest.repository

import android.app.Application
import com.projectseoul.stockmarkettest.database.AppDatabase
import com.projectseoul.stockmarkettest.network.CommodityService
import com.projectseoul.stockmarkettest.network.NetworkService
import com.projectseoul.stockmarkettest.network.StockMarketService
import com.projectseoul.stockmarkettest.network.UpbitService
import com.projectseoul.stockmarkettest.utils.Const
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by KING JINHO on 9/14/2021
 */
abstract class BaseRepo(application: Application) {

    protected val db by lazy {
        AppDatabase.getInstance(application)
    }

    protected val stockMarket: StockMarketService by lazy {
        NetworkService.STOCK_MARKET_SERVICE
    }

    protected val upbit: UpbitService by lazy {
        NetworkService.UPBIT_SERVICE
    }

    protected val commodity: CommodityService by lazy {
        NetworkService.COMMODITY_SERVICE
    }

}