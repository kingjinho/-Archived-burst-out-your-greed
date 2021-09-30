package com.projectseoul.stockmarkettest.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by KING JINHO on 9/14/2021
 */
@JsonClass(generateAdapter = true)
@Entity(tableName = Const.TABLE_STOCK, primaryKeys = [Const.COLUMN_STOCK_CODE, Const.COLUMN_KD])
data class Stock(
    @ColumnInfo(name = Const.COLUMN_KD)
    @Json(name = Const.JSON_ISU_CD)
    val kd: String,

    @ColumnInfo(name = Const.COLUMN_STOCK_CODE)
    @Json(name = Const.JSON_ISU_SRT_CD)
    val stockCode: String,

    @ColumnInfo(name = Const.COLUMN_COMPANY_NAME)
    @Json(name = Const.JSON_ISU_ABBRV)
    val companyName: String,

    @ColumnInfo(name = Const.COLUMN_COMPANY_NAME_ENG)
    @Json(name = Const.JSON_ISU_ENG_NM)
    val companyNameEng: String,

    @ColumnInfo(name = Const.COLUMN_DATE_LISTED)
    @Json(name = Const.JSON_LIST_DD)
    val companyDateListed: String,

    @ColumnInfo(name = Const.COLUMN_STOCK_MARKET)
    @Json(name = Const.JSON_MKT_TP_NM)
    val stockMarket: String,

    @ColumnInfo(name = Const.COLUMN_COMMON_PREFERRED)
    @Json(name = Const.JSON_KIND_STKCERT_TP_NM)
    val commonOrPreferred: String,

    @ColumnInfo(name = Const.COLUMN_TOTAL_SHARES)
    @Json(name = Const.JSON_LIST_SHRS)
    val stockIssued: String,

    @ColumnInfo(name = Const.COLUMN_SECTOR)
    var sector: String? = Const.NOT_APPLICABLE
)
