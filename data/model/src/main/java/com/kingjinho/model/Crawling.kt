package com.kingjinho.model

import com.kingjinho.shared.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/14/2021
 */
data class Crawling<T: Any>(
    @Json(name = Const.JSON_OUT_BLOCK_1)
    val result: List<T>? = emptyList()
)


