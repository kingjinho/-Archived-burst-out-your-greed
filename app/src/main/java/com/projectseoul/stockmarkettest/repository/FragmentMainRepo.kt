package com.projectseoul.stockmarkettest.repository

import android.app.Application
import com.projectseoul.stockmarkettest.extensions.execute
import com.projectseoul.stockmarkettest.extensions.executeMultiple
import com.projectseoul.stockmarkettest.extensions.getBodyExt
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.utils.Const
import com.projectseoul.stockmarkettest.utils.Dates.mostCurrentDate
import com.projectseoul.stockmarkettest.utils.Dates.weekAgo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.internal.toImmutableList

/**
 * Created by KING JINHO on 9/15/2021
 */
class FragmentMainRepo(application: Application) : BaseRepo(application) {

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


    val top50ByFluctuation = flow {
        if (fluctuation.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    stockMarket.getTop50ByFluctuation(1, mostCurrentDate, mostCurrentDate),
                    stockMarket.getTop50ByFluctuation(2, mostCurrentDate, mostCurrentDate)
                )
            )

            val result = mutableListOf<StockByFluctuation>()
            asyncResult.forEach { response ->
                response.getBodyExt {
                    val data = it?.result
                    if (data != null && data.isNotEmpty()) {
                        result.addAll(data)
                    }
                }
            }
            fluctuation = result.toImmutableList()
        }
        emit(HeaderWithFluctuation(fluctuation!!))
    }.flowOn(Dispatchers.IO)

    val top50ByTransaction = flow {
        if (transaction.isNullOrEmpty()) {

            val asyncResult = execute {
                stockMarket.getTop50ByTransaction(1, mostCurrentDate, mostCurrentDate)
            }?.getBodyExt {
                it?.result
            }
            transaction = asyncResult ?: emptyList()
        }
        emit(HeaderWithTransaction(transaction!!))
    }

    val top50ByMarketCap = flow {
        if (marketCap.isNullOrEmpty()) {
            val asyncResult = execute {
                stockMarket.getTop50ByMarketCap(mostCurrentDate)
            }?.getBodyExt {
                it?.result
            }
            marketCap = asyncResult ?: emptyList()
        }
        emit(HeaderWithMarketCap(marketCap!!))
    }

    val upperLowerLimit = flow {
        if (upperLower.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    stockMarket.getByUpperLowerLimit(4, mostCurrentDate),
                    stockMarket.getByUpperLowerLimit(5, mostCurrentDate)
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

        emit(HeaderWithUpperLowerLimit(upperLower!!))
    }

    val top50ByForeigner = flow {
        if (foreigner.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    stockMarket.getTop50ByForeigner(1, mostCurrentDate),
                    stockMarket.getTop50ByForeigner(2, mostCurrentDate)
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

        emit(HeaderWithForeigner(foreigner!!))
    }

    val top50ByTurnover = flow {
        if (turnover.isNullOrEmpty()) {
            val asyncResult = execute {
                stockMarket.getTop50ByTurnover(mostCurrentDate)
            }?.getBodyExt {
                it?.result
            }
            turnover = asyncResult ?: emptyList()
        }
        emit(HeaderWithTurnover(turnover!!))
    }

    val blockDealFlow = flow {
        if (blockDeal.isNullOrEmpty()) {
            val asyncResult = execute {
                stockMarket.getBlockTrade()
            }?.getBodyExt {
                it?.result
            }
            blockDeal = asyncResult ?: emptyList()
        }
        emit(HeaderWithBlockDeal(blockDeal!!))
    }

    val cornWheatSoyBean = flow {
        if (grains.isNullOrEmpty()) {
            val asyncResult = executeMultiple(
                listOf(
                    commodity.getGrain(Const.PATH_WHEAT, weekAgo, mostCurrentDate),
                    commodity.getGrain(Const.PATH_CORN, weekAgo, mostCurrentDate),
                    commodity.getGrain(Const.PATH_SOYBEAN, weekAgo, mostCurrentDate)
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
        emit(HeaderWithGrains(grains!!))
    }

    val crudeOil = flow {
        if (oil.isNullOrEmpty()) {
            val asyncResult = execute {
                commodity.getCrudeOil(weekAgo, mostCurrentDate)
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

        emit(HeaderWithOil(oil!!))
    }

    val balticIndex = flow {
        if (indices.isNullOrEmpty()) {
            val asyncResult = execute {
                commodity.getBDIs(weekAgo, mostCurrentDate)
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
        emit(HeaderWithBalticIndices(indices!!))
    }
}