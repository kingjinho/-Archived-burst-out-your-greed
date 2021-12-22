package com.projectseoul.stockmarkettest.dao

import androidx.room.Dao
import androidx.room.Query
import com.projectseoul.stockmarkettest.entities.CryptoCurrency
import com.projectseoul.stockmarkettest.utils.Const

/**
 * Created by KING JINHO on 9/16/2021
 */
@Dao
abstract class CryptoCurrencyDao : BaseDao<CryptoCurrency> {

    @Query("DELETE FROM ${Const.TABLE_CRYPTO_CURRENCY}")
    abstract fun deleteAll()

}