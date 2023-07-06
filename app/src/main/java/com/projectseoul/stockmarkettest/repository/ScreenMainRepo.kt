package com.projectseoul.stockmarkettest.repository

import com.projectseoul.stockmarkettest.extensions.getBodyExt
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.network.CommodityService
import com.projectseoul.stockmarkettest.network.ImportExportService
import com.projectseoul.stockmarkettest.network.StockMarketService
import com.projectseoul.stockmarkettest.utils.Const
import com.projectseoul.stockmarkettest.utils.Dates
import com.projectseoul.stockmarkettest.utils.Dates.mostCurrentDate
import com.projectseoul.stockmarkettest.utils.Dates.weekAgo
import com.projectseoul.stockmarkettest.utils.execute
import com.projectseoul.stockmarkettest.utils.executeMultiple
import okhttp3.internal.toImmutableList
import java.util.PrimitiveIterator
import javax.inject.Inject

/**
 * Created by KING JINHO on 9/15/2021
 */
class ScreenMainRepo @Inject constructor(
    private val stockMarketService: StockMarketService,
    private val commodityService: CommodityService,
    private val importExportService: ImportExportService
) {

    private var fluctuation: List<StockByFluctuation>? = null
    private var transaction: List<StockByTransaction>? = null
    private var marketCap: List<StockByMarketCap>? = null
    private var upperLower: List<StockByUpperLowerLimit>? = null
    private var foreigner: List<StockByForeigner>? = null
    private var turnover: List<StockByTurnover>? = null
    private var blockDeal: List<StockByBlockDeal>? = null
    private var grains: List<Grain>? = null
    private var oil: List<CrudeOil>? = null
    private var indices: List<BDIIndex>? = null
    private var monthlyTrading: List<MonthlyTrading>? = null


    suspend fun getTop50ByFluctuation(): HeaderWithFluctuation {
        if (fluctuation.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    stockMarketService.getTop50ByFluctuation(1, mostCurrentDate, mostCurrentDate),
                    stockMarketService.getTop50ByFluctuation(2, mostCurrentDate, mostCurrentDate)
                )
            )

            val result = mutableListOf<StockByFluctuation>()
            asyncResult.forEach { response ->
                response.getBodyExt {
                    val data = it?.result
                    if (!data.isNullOrEmpty()) {
                        result.addAll(data)
                    }
                }
            }
            fluctuation = result.toImmutableList()
        }
        return HeaderWithFluctuation(fluctuation!!)
    }

    suspend fun getTop50ByTransaction(): HeaderWithTransaction {
        if (transaction.isNullOrEmpty()) {

            val asyncResult = execute {
                stockMarketService.getTop50ByTransaction(1, mostCurrentDate, mostCurrentDate)
            }?.getBodyExt {
                it?.result
            }
            transaction = asyncResult ?: emptyList()
        }
        return HeaderWithTransaction(transaction!!)
    }

    suspend fun top50ByMarketCap(): HeaderWithMarketCap {
        if (marketCap.isNullOrEmpty()) {
            val asyncResult = execute {
                stockMarketService.getTop50ByMarketCap(mostCurrentDate)
            }?.getBodyExt {
                it?.result
            }
            marketCap = asyncResult ?: emptyList()
        }
        return HeaderWithMarketCap(marketCap!!)
    }

    suspend fun getUpperLowerLimit(): HeaderWithUpperLowerLimit {
        if (upperLower.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    stockMarketService.getByUpperLowerLimit(4, mostCurrentDate),
                    stockMarketService.getByUpperLowerLimit(5, mostCurrentDate)
                )
            )

            val result = mutableListOf<StockByUpperLowerLimit>()
            asyncResult.forEach {
                it.getBodyExt { data ->
                    result += data?.result ?: emptyList()
                }
            }
            upperLower = result.toImmutableList()
        }
        return HeaderWithUpperLowerLimit(upperLower!!)
    }

    suspend fun getTop50ByForeigner(): HeaderWithForeigner {
        if (foreigner.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    stockMarketService.getTop50ByForeigner(1, mostCurrentDate),
                    stockMarketService.getTop50ByForeigner(2, mostCurrentDate)
                )
            )
            val result = mutableListOf<StockByForeigner>()

            asyncResult.forEach {
                it.getBodyExt { data ->
                    result +=
                        data?.result ?: emptyList()
                }
            }
            foreigner = result.toImmutableList()
        }

        return HeaderWithForeigner(foreigner!!)
    }

    suspend fun getTop50ByTurnover(): HeaderWithTurnover {
        if (turnover.isNullOrEmpty()) {
            val asyncResult = execute {
                stockMarketService.getTop50ByTurnover(mostCurrentDate)
            }?.getBodyExt {
                it?.result
            }
            turnover = asyncResult ?: emptyList()
        }
        return HeaderWithTurnover(turnover!!)
    }

    suspend fun getBlockDealFlow(): HeaderWithBlockDeal {
        if (blockDeal.isNullOrEmpty()) {
            val asyncResult = execute {
                stockMarketService.getBlockTrade()
            }?.getBodyExt {
                it?.result
            }
            blockDeal = asyncResult ?: emptyList()
        }
        return HeaderWithBlockDeal(blockDeal!!)
    }

    suspend fun getCornWheatSoyBean(): HeaderWithGrains {
        if (grains.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    commodityService.getGrain(Const.PATH_WHEAT, weekAgo, mostCurrentDate),
                    commodityService.getGrain(Const.PATH_CORN, weekAgo, mostCurrentDate),
                    commodityService.getGrain(Const.PATH_SOYBEAN, weekAgo, mostCurrentDate)
                )
            )
            val data = mutableListOf<Grain>()

            asyncResult.forEach { response ->
                response.getBodyExt { list ->
                    list?.forEach {
                        var grainFound = data.find { x -> x.date == it.date }
                        if (grainFound == null) {
                            grainFound = Grain(it.date)
                            data += grainFound
                        }

                        grainFound.run {
                            when (asyncResult.indexOf(response)) {
                                0 -> {
                                    wheatPrice = it.price
                                    wheatVolume = it.volume
                                }

                                1 -> {
                                    cornPrice = it.price
                                    cornVolume = it.volume
                                }

                                else -> {
                                    soyBeanPrice = it.price
                                    soyBeanVolume = it.volume
                                }
                            }
                        }
                    }
                }
            }
            data.sortByDescending { it.date }
            grains = data.toImmutableList()
        }
        return HeaderWithGrains(grains!!)
    }

    suspend fun getCrudeOil(): HeaderWithOil {
        if (oil.isNullOrEmpty()) {
            val asyncResult = execute {
                commodityService.getCrudeOil(weekAgo, mostCurrentDate)
            }

            val result = when (asyncResult) {
                null -> null
                else -> asyncResult.getBodyExt {
                    it
                }
            }?.toMutableList()
            result?.sortByDescending { it.date }
            oil = result ?: emptyList()
        }

        return HeaderWithOil(oil!!)
    }

    suspend fun getBalticIndex(): HeaderWithBalticIndices {
        if (indices.isNullOrEmpty()) {
            val asyncResult = execute {
                commodityService.getBDIs(weekAgo, mostCurrentDate)
            }

            val result = when (asyncResult) {
                null -> null
                else ->
                    asyncResult.getBodyExt {
                        it ?: emptyList()
                    }
            }?.toMutableList()

            result?.sortByDescending { it.date }
            indices = result ?: emptyList()
        }
        return HeaderWithBalticIndices(indices!!)
    }

    suspend fun getImportExport(): HeaderWithMonthlyTrading {
        if (monthlyTrading.isNullOrEmpty()) {
            val asyncResult = execute {
                importExportService.getMonthlyTradingData(
                    "${Dates.currentYear}01", "${Dates.currentYear}${Dates.currentMonth}"
                )
            }

            val result = asyncResult?.getBodyExt { it?.items }
            monthlyTrading = result?.sortedByDescending { it.period } ?: emptyList()
        }

        return HeaderWithMonthlyTrading(monthlyTrading!!)
    }
}