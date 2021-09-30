package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/30/2021
 */
@JsonClass(generateAdapter = true)
data class CryptoCurrencyJson(

    @Json(name = Const.JSON_UPBIT_TICKER)
    val ticker: String,
    @Json(name = Const.JSON_UPBIT_TICKER_NAME)
    val name: String,
    @Json(name = Const.JSON_UPBIT_TICKER_NAME_ENG)
    val nameEng: String,
    @Json(name = Const.JSON_UPBIT_MARKET_WARNING)
    val hasWarning: String
)