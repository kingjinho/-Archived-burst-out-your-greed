package com.projectseoul.stockmarkettest.network

import com.projectseoul.stockmarkettest.entities.CryptoCurrency
import com.projectseoul.stockmarkettest.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by KING JINHO on 9/15/2021
 */
interface UpbitService {

    @GET(Const.PATH_UPBIT_GET_ALL_TICKERS)
    suspend fun getAllTickers(@Query(Const.UPBIT_GET_ALL_TICKERS) isDetailed: Boolean): Response<List<CryptoCurrency>>
}