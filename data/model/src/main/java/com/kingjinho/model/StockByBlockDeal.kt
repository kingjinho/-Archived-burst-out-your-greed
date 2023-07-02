package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/16/2021
 */
@JsonClass(generateAdapter = true)
data class StockByBlockDeal(
    @Json(name = Const.JSON_ISU_SRT_CD)
    val stockCode: String,

    @Json(name = Const.JSON_ISU_NM)
    val name: String,

    @Json(name = Const.JSON_TDD_CLSPRC)
    val closing: String,

    @Json(name = Const.JSON_CMPPRVDD_PRC)
    val diff: String,

    @Json(name = Const.JSON_FLUC_RT)
    val diffInRatio: String,

    @Json(name = Const.JSON_ACC_TRDVOL)
    val volume: String,

    @Json(name = Const.JSON_BLK_TRDVOL)
    val blockDealVolume: String,

    @Json(name = Const.JSON_BLK_TRD_RTO)
    val blockDealRatio: String
)
