package com.projectseoul.stockmarkettest.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by KING JINHO on 9/14/2021
 */
class DateAdapter {
    private val dateFormat = SimpleDateFormat("yyyyMMdd")
    @ToJson
    fun toJson(date: Date): String {
        return dateFormat.format(date)
    }

    @FromJson
    fun fromJson(date: String): Date {
        return dateFormat.parse(date)!!
    }
}