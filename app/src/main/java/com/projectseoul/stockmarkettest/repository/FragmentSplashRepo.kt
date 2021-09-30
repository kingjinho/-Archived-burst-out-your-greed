package com.projectseoul.stockmarkettest.repository

import android.app.Application
import androidx.room.withTransaction
import com.projectseoul.stockmarkettest.extensions.getBodyExt
import com.projectseoul.stockmarkettest.models.SectorCrawling
import com.projectseoul.stockmarkettest.utils.Const
import com.projectseoul.stockmarkettest.utils.Dates.mostCurrentDate
import kotlinx.coroutines.*
import retrofit2.Response
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by KING JINHO on 9/14/2021
 */
class FragmentSplashRepo(application: Application) : BaseRepo(application) {


    suspend fun refreshData(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val companiesDeferred =
                    async {
                        stockMarket.scrapeCompanies(
                            Const.CRAWLING_COMPANY_VALUE1,
                            Const.CRAWLING_VALUE_ALL
                        )
                    }

                val sectorListDeferred: List<Deferred<Response<SectorCrawling>>> = listOf(
                    async {
                        stockMarket.getSectors(
                            Const.CRAWLING_SECTOR_VALUE1,
                            Const.CRAWLING_VALUE_KOSPI,
                            mostCurrentDate
                        )
                    },
                    async {
                        stockMarket.getSectors(
                            Const.CRAWLING_SECTOR_VALUE1,
                            Const.CRAWLING_VALUE_KOSDAQ,
                            mostCurrentDate
                        )
                    }
                )
                val digitalCurrenciesDeferred = async {
                    upbit.getAllTickers(true)
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
}