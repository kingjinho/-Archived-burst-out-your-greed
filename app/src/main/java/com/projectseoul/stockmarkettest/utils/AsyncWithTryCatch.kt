package com.projectseoul.stockmarkettest.extensions

import kotlinx.coroutines.*
import retrofit2.Response

/**
 * Created by KING JINHO on 9/16/2021
 */

suspend fun <T> execute(action: suspend () -> T): T? {
    return coroutineScope {
        try {
            val deferred = async(Dispatchers.IO) {
                action.invoke()
            }
            deferred.await()
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}

suspend fun <T> executeMultiple(list: List<Response<T>>): List<Response<T>> {
    return coroutineScope {
        try {
            val data = list.map {
                async(Dispatchers.IO) { it }
            }
            data.awaitAll()
        } catch (ex: Exception) {
            ex.printStackTrace()
            emptyList()
        }
    }
}