package com.projectseoul.stockmarkettest.repository

import android.app.Application
import com.projectseoul.stockmarkettest.database.AppDatabase
import com.projectseoul.stockmarkettest.network.NetworkService

/**
 * Created by KING JINHO on 9/14/2021
 */
abstract class BaseRepo(application: Application) {

    protected val db = AppDatabase.getInstance(application)

    protected val stockMarketService = NetworkService.STOCK_MARKET_SERVICE

    protected val upbitService = NetworkService.UPBIT_SERVICE

    protected val commodityService = NetworkService.COMMODITY_SERVICE

    protected val importExportService = NetworkService.IMPORT_EXPORT_SERVICE

}