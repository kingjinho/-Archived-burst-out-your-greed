package com.projectseoul.stockmarkettest.annotations

import com.squareup.moshi.JsonQualifier

/**
 * Created by KING JINHO on 9/17/2021
 */
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class HasWarning {
}