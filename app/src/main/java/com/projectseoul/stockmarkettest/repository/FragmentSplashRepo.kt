package com.projectseoul.stockmarkettest.repository

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import androidx.room.withTransaction
import com.projectseoul.stockmarkettest.database.AppDatabase
import com.projectseoul.stockmarkettest.extensions.getBodyExt
import com.projectseoul.stockmarkettest.models.SectorCrawling
import com.projectseoul.stockmarkettest.network.StockMarketService
import com.projectseoul.stockmarkettest.network.UpbitService
import com.projectseoul.stockmarkettest.utils.Const
import com.projectseoul.stockmarkettest.utils.Dates.mostCurrentDate
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by KING JINHO on 9/14/2021
 */
class FragmentSplashRepo @Inject constructor(
    val application: Application,
    private val stockMarketService: StockMarketService,
    private val upbitService: UpbitService,
    private val db: AppDatabase
) {

    private val sharedPref by lazy {
        application.getSharedPreferences(Const.SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    suspend fun refreshData(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val companiesDeferred =
                    async {
                        stockMarketService.scrapeCompanies(
                            Const.CRAWLING_COMPANY_VALUE1,
                            Const.CRAWLING_VALUE_ALL
                        )
                    }

                val sectorListDeferred: List<Deferred<Response<SectorCrawling>>> = listOf(
                    async {
                        stockMarketService.getSectors(
                            Const.CRAWLING_SECTOR_VALUE1,
                            Const.CRAWLING_VALUE_KOSPI,
                            mostCurrentDate
                        )
                    },
                    async {
                        stockMarketService.getSectors(
                            Const.CRAWLING_SECTOR_VALUE1,
                            Const.CRAWLING_VALUE_KOSDAQ,
                            mostCurrentDate
                        )
                    }
                )
                val digitalCurrenciesDeferred = async {
                    upbitService.getAllTickers(true)
                }

                val companiesResponse = companiesDeferred.await()
                val companies = companiesResponse.getBodyExt {
                    if (it != null) it.result else emptyList()
                }

                val sectorList = sectorListDeferred.awaitAll()
                val sectorsKospi = sectorList[0].getBodyExt {
                    if (it != null) it.result else emptyList()
                }
                val sectorsKosdaq = sectorList[1].getBodyExt {
                    if (it != null) it.result else emptyList()
                }
                val aggregateSector = sectorsKosdaq?.plus(sectorsKospi ?: emptyList())
                companies?.forEach {
                    aggregateSector?.find { sector -> it.stockCode == sector.stockCode }
                        ?.apply {
                            it.sector = this.Sector
                        }
                }

                val digitalCurrencies = digitalCurrenciesDeferred.await().getBodyExt {
                    it ?: emptyList()
                }


                db.withTransaction {
                    db.stockDao().deleteAll()
                    db.cryptoCurrencyDao().deleteAll()
                    db.stockDao().insertAll(companies!!)
                    db.cryptoCurrencyDao().insertAll(digitalCurrencies!!)
                }

                return@withContext true
            } catch (ex: Exception) {
                ex.printStackTrace()
                return@withContext false
            }
        }
    }

    fun getLastUpdateDateInMilliSeconds(): Long {
        return sharedPref.getLong(Const.SHARED_PREF_KEY_LAST_UPDATE, 0)
    }

    fun updateLastUpdateDateInMilliSeconds() {
        sharedPref.edit {
            putLong(
                Const.SHARED_PREF_KEY_LAST_UPDATE,
                System.currentTimeMillis()
            )
        }
    }
}