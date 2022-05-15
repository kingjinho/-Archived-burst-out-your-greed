package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/15/2021
 */
//외국인 보유
@JsonClass(generateAdapter = true)
data class StockByForeigner(
    @Json(name = Const.JSON_TDD_CLSPRC)
    val closing: String,

    @Json(name = Const.JSON_HD_QTY)
    val sharesOwned: String,

    @Json(name = Const.JSON_FORN_ORD_LMT_QTY)
    val maxSharesToOwn: String,

    @Json(name = Const.JSON_HD_RTO)
    val sharesOwnedInRatio: String, //외국인 지분율

    @Json(name = Const.JSON_ITM_RTO)
    val currentLimitRatio: String,//한도 소진율

    @Json(name = Const.JSON_LIST_SHRS)
    val stockIssued: String

) : BaseStock()
