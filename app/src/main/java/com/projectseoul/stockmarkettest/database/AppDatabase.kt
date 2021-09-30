package com.projectseoul.stockmarkettest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.projectseoul.stockmarkettest.dao.CryptoCurrencyDao
import com.projectseoul.stockmarkettest.dao.StockDao
import com.projectseoul.stockmarkettest.entities.CryptoCurrency
import com.projectseoul.stockmarkettest.entities.Stock
import com.projectseoul.stockmarkettest.utils.Const

/**
 * Created by KING JINHO on 9/14/2021
 */
@Database(entities = [Stock::class, CryptoCurrency::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun stockDao(): StockDao
    abstract fun cryptoCurrencyDao(): CryptoCurrencyDao

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null
        private const val DB_NAME = Const.DB_NAME

        fun getInstance(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}