package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/28/2021
 */
data class StockBaseInfo(
    @Json(name = Const.JSON_ISU_NM)
    val name: String,

    @Json(name = Const.JSON_ISU_SRT_CD)
    val stockCode: String,

    @Json(name = Const.JSON_MKT_NM)
    val market: String,

    @Json(name = Const.JSON_PRSNT_PRC)
    val current: String,

    @Json(name = Const.JSON_CMPPREVDD_PRC)
    val diff: String,

    @Json(name = Const.JSON_FLUC_RT)
    val diffInRatio: String,

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

    @Json(name = Const.JSON_WK52_HGST_PRC)
    val week52High: String,

    @Json(name = Const.JSON_WK52_LWST_PRC)
    val week52Low: String,

    @Json(name = Const.JSON_FORN_RTO)
    val foreignerRatio: String
)
