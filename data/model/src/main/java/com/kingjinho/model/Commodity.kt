package com.kingjinho.model

import com.kingjinho.shared.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/16/2021
 */
data class Grain(
    val date: String
) {
    lateinit var cornPrice: String
    lateinit var wheatPrice: String
    lateinit var soyBeanPrice: String
    lateinit var cornVolume: String
    lateinit var wheatVolume: String
    lateinit var soyBeanVolume: String
}

@JsonClass(generateAdapter = true)
data class CrudeOil(
    @Json(name = Const.JSON_WTI)
    val WTI: String,
    @Json(name = Const.JSON_BRENT)
    val Brent: String,
    @Json(name = Const.JSON_DUBAI)
    val Dubai: String,
    val date: String,
)

data class BDIIndex(

    val date: String,
    val bdi: String,
    val bci: String,
    val bpi: String,
    val bsi: String,
    val bhsi: String
)

@JsonClass(generateAdapter = true)
data class CornSoyWheatJson(
    val date: String,
    val open: String,
    val close: String,
    val high: String,
    val low: String,
    @Json(name = Const.JSON_SETTLEMENT)
    val price: String,
    val volume: String,
)

@JsonClass(generateAdapter = true)
data class SugarCottonJson(
    val open: String,
    val id: String,
    val high: String,
    val low: String,
    val last: String,
    @Json(name = Const.JSON_SETTLE)
    val price: String,

    val volume: String,
    val date: String,

    )

@JsonClass(generateAdapter = true)
data class CoffeeJson(
    val date: String,
    val price: String,
)
