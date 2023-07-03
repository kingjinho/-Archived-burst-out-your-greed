package com.projectseoul.stockmarkettest.models

import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/28/2021
 */
data class StockFinancialStatement(
    @Json(name = Const.JSON_ASST_TOTAMT)
    val totalAsset: String,
    @Json(name = Const.JSON_DEBT_TOTAMT)
    val totalDebt: String,
    @Json(name = Const.JSON_CAP)
    val capital: String,
    @Json(name = Const.JSON_CAP_GRNDTOT)
    val totalCapital: String,
    @Json(name = Const.JSON_SALES)
    val sales: String,
    @Json(name = Const.JSON_OPERPROFT_AMT)
    val opIncome: String,
    @Json(name = Const.JSON_NETINCM)
    val netIncome: String,
) {
    override fun equals(other: Any?): Boolean {
        return (other as StockFinancialStatement?)?.let {
            this.totalAsset == it.totalAsset && this.totalDebt == it.totalDebt
                    && this.capital == it.capital
                    && this.totalCapital == it.totalCapital
                    && this.sales == it.sales
                    && this.opIncome == it.opIncome
                    && this.netIncome == netIncome
        } ?: false
    }
}