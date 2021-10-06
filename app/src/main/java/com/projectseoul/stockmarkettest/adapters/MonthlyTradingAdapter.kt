package com.projectseoul.stockmarkettest.adapters

import com.projectseoul.stockmarkettest.models.MonthlyTrading
import com.squareup.moshi.FromJson

/**
 * Created by KING JINHO on 10/5/2021
 */

class MonthlyTradingAdapter {
    @FromJson
    fun fromJson(value: MonthlyTrading): MonthlyTrading {
        return MonthlyTrading(value.period.trim(),
        value.exportVolume.trim(),
        value.exportAmount.trim(),
        value.importVolume.trim(),
        value.importAmount.trim(),
        value.surplus.trim())
    }
}