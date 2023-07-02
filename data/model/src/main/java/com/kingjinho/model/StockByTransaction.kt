package com.kingjinho.model

import com.kingjinho.shared.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/15/2021
 */
//거래 상하위 50
@JsonClass(generateAdapter = true)
data class StockByTransaction(

    @Json(name = Const.JSON_ACC_TRDVOL)
    val volume: String,

    @Json(name = Const.JSON_ACC_TRDVAL)
    val amount: String,

    @Json(name = Const.JSON_BAS_PRC)
    val base: String,

    @Json(name = Const.JSON_CLSPRC)
    val closing: String,


) : BaseStock()
