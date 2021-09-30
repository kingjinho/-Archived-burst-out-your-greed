package com.projectseoul.stockmarkettest.adapters

import com.projectseoul.stockmarkettest.annotations.HasWarning
import com.projectseoul.stockmarkettest.utils.Const
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * Created by KING JINHO on 9/15/2021
 */
class CryptoCurrencyAdapter {

    @FromJson
    @HasWarning
    fun fromJson(hasWarning: String): Boolean {
        return hasWarning == Const.UPBIT_WARNING
    }

    @ToJson
    fun toJson(@HasWarning hasWarning: Boolean): String {
        return if(hasWarning) Const.UPBIT_WARNING else Const.UPBIT_NONE
    }
}