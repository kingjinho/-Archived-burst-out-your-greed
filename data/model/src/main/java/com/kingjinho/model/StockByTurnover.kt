package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/15/2021
 */
@JsonClass(generateAdapter = true)
data class StockByTurnover(
    @Json(name = Const.JSON_TDD_CLSPRC)
    val closing: String,

    @Json(name = Const.JSON_TURNOVER_RT)
    val turnoverRatio : String,

    @Json(name = Const.JSON_ACC_TRDVOL)
    val volume: String,

    @Json(name = Const.JSON_ACC_TRDVAL)
    val amount: String,

    @Json(name = Const.JSON_LIST_SHRS)
    val stockIssued: String

) : BaseStock()
