package com.projectseoul.stockmarkettest.extensions

/**
 * Created by KING JINHO on 9/14/2021
 */

fun <T,R> retrofit2.Response<T>.getBodyExt(action: (T?) -> R) : R? {
    val body = if(isSuccessful) body() else null
    return action.invoke(body)
}