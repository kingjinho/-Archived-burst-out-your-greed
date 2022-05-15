package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/15/2021
 */
//주가 등락률 상하위
@JsonClass(generateAdapter = true)
data class StockByFluctuation(

    @Json(name = Const.JSON_BAS_PRC)
    var base: String,
    @Json(name = Const.JSON_CLSPRC)
    var closing: String,
    @Json(name = Const.JSON_ACC_TRDVOL)
    var volume: String,
    @Json(name = Const.JSON_ACC_TRDVAL)
    var amount: String,

) : BaseStock()