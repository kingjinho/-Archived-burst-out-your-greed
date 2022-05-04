package com.projectseoul.stockmarkettest.dao

import androidx.room.Dao
import androidx.room.Query
import com.projectseoul.stockmarkettest.entities.Stock
import com.projectseoul.stockmarkettest.utils.Const

/**
 * Created by KING JINHO on 9/14/2021
 */
@Dao
abstract class StockDao : BaseDao<Stock> {

    @Query("SELECT * FROM ${Const.TABLE_STOCK}")
    abstract fun getAll() : List<Stock>

    @Query("DELETE FROM ${Const.TABLE_STOCK}")
    abstract fun deleteAll()

    @Query("SELECT KD FROM ${Const.TABLE_STOCK} WHERE STOCK_CODE = :stockCode")
    abstract fun getKD(stockCode: String) : String?
}