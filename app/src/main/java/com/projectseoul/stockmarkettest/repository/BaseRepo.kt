package com.projectseoul.stockmarkettest.repository

import android.app.Application
import com.projectseoul.stockmarkettest.database.AppDatabase
import com.projectseoul.stockmarkettest.network.NetworkService

/**
 * Created by KING JINHO on 9/14/2021
 */
abstract class BaseRepo(application: Application) {

    protected val db = AppDatabase.getInstance(application)

    protected val stockMarket = NetworkService.STOCK_MARKET_SERVICE

    protected val upbit = NetworkService.UPBIT_SERVICE

    protected val commodity = NetworkService.COMMODITY_SERVICE

    protected val importExport = NetworkService.IMPORT_EXPORT_SERVICE

}