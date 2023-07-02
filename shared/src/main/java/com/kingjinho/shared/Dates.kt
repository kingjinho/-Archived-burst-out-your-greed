package com.kingjinho.shared

import java.time.DayOfWeek
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by KING JINHO on 9/30/2021
 */
object Dates {
    private val today: ZonedDateTime = ZonedDateTime.now(ZoneId.of(Const.TIME_ZONE_SEOUL))

    val mostCurrentDate: String by lazy {
        /**
         * weekday : Friday
         * 00:00 ~ 09:20 a day before
         * 09:20 ~ 23:59 today
         */
        val currentDate = when (today.dayOfWeek) {
            DayOfWeek.SATURDAY -> today.minusDays(1)
            DayOfWeek.SUNDAY -> today.minusDays(2)
            else -> {
                if (today.hour < 9) today.minusDays(1)
                else today
            }
        }
        currentDate.format(DateTimeFormatter.ofPattern(Const.DATE_FORMAT))
    }

    val weekAgo: String by lazy {
        val weekAgo = when (today.dayOfWeek) {
            DayOfWeek.SATURDAY -> today.minusDays(8)
            DayOfWeek.SUNDAY -> today.minusDays(9)
            else -> today.minusDays(7)
        }
        weekAgo.format(DateTimeFormatter.ofPattern(Const.DATE_FORMAT))
    }

    val yearAgo: String by lazy {
        val yearAgo = today.minusYears(1)
        yearAgo.format(DateTimeFormatter.ofPattern(Const.DATE_FORMAT))
    }

    const val oldestDate = "19960103"

    val currentYear: String by lazy {
        "${today.year}"
    }
    val currentMonth: String by lazy {
        "$today.monthValue"
    }
}
