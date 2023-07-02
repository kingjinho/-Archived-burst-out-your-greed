package com.kingjinho.model

import com.kingjinho.shared.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/14/2021
 */
data class SectorCrawling(
    @Json(name = Const.JSON_BLOCK_1)
    val result: List<Sector>? = emptyList()
)

data class Sector(
    @Json(name = Const.JSON_ISU_SRT_CD)
    val stockCode: String,
    @Json(name = Const.JSON_IDX_IND_NM)
    val Sector: String? = Const.NOT_APPLICABLE
)
