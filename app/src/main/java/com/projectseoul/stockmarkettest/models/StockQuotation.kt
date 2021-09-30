package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/28/2021
 */
data class StockQuotation(
    @Json(name = Const.JSON_TRD_DD)
    val date: String,
    @Json(name = Const.JSON_TDD_CLSPRC)
    val closing: String,
    @Json(name = Const.JSON_CMPPREVDD_PRC)
    val diff: String,
    @Json(name = Const.JSON_FLUC_RT)
    val diffRatio: String,
    @Json(name = Const.JSON_TDD_OPNPRC)
    val opening: String,
    @Json(name = Const.JSON_TDD_HGPRC)
    val high: String,
    @Json(name = Const.JSON_TDD_LWPRC)
    val low: String,
    @Json(name = Const.JSON_ACC_TRDVOL)
    val volume: String,
    @Json(name = Const.JSON_ACC_TRDVAL)
    val amount: String,
    @Json(name = Const.JSON_MKTCAP)
    val marketCap: String,
    @Json(name = Const.JSON_LIST_SHRS)
    val totalShares: String
)
