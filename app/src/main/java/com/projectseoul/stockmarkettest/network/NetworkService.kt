package com.projectseoul.stockmarkettest.network

import android.util.Log
import com.projectseoul.stockmarkettest.BuildConfig
import com.projectseoul.stockmarkettest.adapters.CryptoCurrencyJsonAdapter
import com.projectseoul.stockmarkettest.adapters.DateJsonAdapter
import com.projectseoul.stockmarkettest.adapters.MonthlyTradingJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by KING JINHO on 9/14/2021
 */
private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .add(DateJsonAdapter())
    .add(CryptoCurrencyJsonAdapter())
    .add(MonthlyTradingJsonAdapter())
    .build()

private val logger = HttpLoggingInterceptor {
    Log.i("API", it)
}.apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder()
    .connectTimeout(100, TimeUnit.SECONDS)
    .readTimeout(100, TimeUnit.SECONDS)
    .writeTimeout(100, TimeUnit.SECONDS)
    .addInterceptor(logger)
    .build()

private val stockMarketRetrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BuildConfig.KRX_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

private val upbitRetrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BuildConfig.UPBIT_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

private val currencyInterestRetrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BuildConfig.CURRENCY_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

private val commodityRetrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BuildConfig.COMMODITY_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()


private val goldSilverRetrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BuildConfig.GOLD_SILVER_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

private val importExportRetrofit = Retrofit.Builder()
    .client(client)
    .baseUrl(BuildConfig.IMPORT_EXPORT_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()


object NetworkService {
    val STOCK_MARKET_SERVICE: StockMarketService by lazy {
        stockMarketRetrofit.create(
            StockMarketService::class.java
        )
    }

    val UPBIT_SERVICE: UpbitService by lazy { upbitRetrofit.create(UpbitService::class.java) }

    val CURRENCY_SERVICE: CurrencyInterestRateService by lazy {
        currencyInterestRetrofit.create(
            CurrencyInterestRateService::class.java
        )
    }

    val COMMODITY_SERVICE: CommodityService by lazy {
        commodityRetrofit.create(CommodityService::class.java)
    }

    val IMPORT_EXPORT_SERVICE : ImportExportService by lazy {
        importExportRetrofit.create(ImportExportService::class.java)
    }
}