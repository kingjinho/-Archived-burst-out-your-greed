package com.projectseoul.stockmarkettest.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.projectseoul.stockmarkettest.annotations.HasWarning
import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/15/2021
 */
@JsonClass(generateAdapter = true)
@Entity(tableName = Const.TABLE_CRYPTO_CURRENCY, primaryKeys = [Const.COLUMN_TICKER])
data class CryptoCurrency(

    @Json(name = Const.JSON_UPBIT_TICKER)
    @ColumnInfo(name = Const.COLUMN_TICKER)
    val ticker: String,

    @Json(name = Const.JSON_UPBIT_TICKER_NAME)
    @ColumnInfo(name = Const.COLUMN_NAME)
    val name: String,

    @Json(name = Const.JSON_UPBIT_TICKER_NAME_ENG)
    @ColumnInfo(name = Const.COLUMN_NAME_ENG)
    val nameEng: String,

    @Json(name = Const.JSON_UPBIT_MARKET_WARNING)
    @ColumnInfo(name = Const.COLUMN_HAS_WARNING)
    @HasWarning
    val hasWarning: Boolean
)
