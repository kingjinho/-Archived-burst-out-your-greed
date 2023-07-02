package com.kingjinho.model

import com.kingjinho.shared.Const
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
    fun equals(other: StockFinancialStatement): Boolean {
        return this.totalAsset == other.totalAsset && this.totalDebt == other.totalDebt
        this.capital == other.capital
        this.totalCapital == other.totalCapital
        this.sales == other.sales
        this.opIncome == other.opIncome
        this.netIncome == netIncome

    }
}
