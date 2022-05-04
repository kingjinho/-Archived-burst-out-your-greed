package com.projectseoul.stockmarkettest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

/**
 * Created by KING JINHO on 9/14/2021
 */

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: T)

    @Delete
    fun delete(data : T)


}

