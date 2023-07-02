package com.kingjinho.model

import com.kingjinho.shared.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 10/5/2021
 */
data class MonthlyTradingJson(
    val count: Int,
    val items: List<MonthlyTrading>
)

@JsonClass(generateAdapter = true)
data class MonthlyTrading(
    @Json(name = Const.JSON_PERIOD_TITLE)
    val period: String,

    @Json(name = Const.JSON_EXPORT_COUNT)
    val exportVolume: String,

    @Json(name = Const.JSON_EXPORT_USD_AMOUNT)
    val exportAmount: String,

    @Json(name = Const.JSON_IMPORT_COUNT)
    val importVolume: String,

    @Json(name = Const.JSON_IMPORT_USD_AMOUNT)
    val importAmount: String,

    @Json(name = Const.JSON_TRADE_SURPLUS)
    val surplus: String,
)
