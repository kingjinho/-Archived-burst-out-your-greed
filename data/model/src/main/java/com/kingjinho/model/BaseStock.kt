package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/15/2021
 */
@JsonClass(generateAdapter = false)
open class BaseStock {
    @Json(name = Const.JSON_ISU_CD)
    var stockCode: String? = null

    @Json(name = Const.JSON_ISU_ABBRV)
    var name: String? = null

    @Json(name = Const.JSON_MKT_NM)
    var market: String? = null

    @Json(name = Const.JSON_CMPPREVDD_PRC)
    var diff: String? = null

    @Json(name = Const.JSON_FLUC_RT)
    var diffInRatio: String? = null
}