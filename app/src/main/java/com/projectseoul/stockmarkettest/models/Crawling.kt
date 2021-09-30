package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/14/2021
 */
data class Crawling<T: Any>(
    @Json(name = Const.JSON_OUT_BLOCK_1)
    val result: List<T>? = emptyList()
)


