package com.kingjinho.model

import com.kingjinho.shared.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/16/2021
 */
data class CrawlingOutput<T>(
    @Json(name = Const.JSON_OUTPUT)
    val result: List<T>?
)
