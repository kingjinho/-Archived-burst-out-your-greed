package com.projectseoul.stockmarkettest.di.application

import android.app.Application
import android.util.Log
import com.projectseoul.stockmarkettest.BuildConfig
import com.projectseoul.stockmarkettest.adapters.CryptoCurrencyJsonAdapter
import com.projectseoul.stockmarkettest.adapters.DateJsonAdapter
import com.projectseoul.stockmarkettest.adapters.MonthlyTradingJsonAdapter
import com.projectseoul.stockmarkettest.di.annotation.named.*
import com.projectseoul.stockmarkettest.di.annotation.scope.AppScope
import com.projectseoul.stockmarkettest.network.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApplicationModule(
    private val application: Application
) {

    @Provides
    @AppScope
    fun application() = application

    @Provides
    @AppScope
    fun moshi() = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .add(DateJsonAdapter())
        .add(CryptoCurrencyJsonAdapter())
        .add(MonthlyTradingJsonAdapter())
        .build()

    @Provides
    @AppScope
    fun logger() = HttpLoggingInterceptor {
        Log.i("API", it)
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @AppScope
    fun client(logger: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .addInterceptor(logger)
        .build()

    @Provides
    @AppScope
    @StockMarketRetrofit
    fun stockMarketRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.KRX_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @AppScope
    @UpbitRetrofit
    fun upbitRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.UPBIT_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @AppScope
    @CurrencyInterestRetrofit
    fun currencyInterestRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.CURRENCY_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @AppScope
    @CommodityRetrofit
    fun commodityRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.COMMODITY_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @AppScope
    @GoldSilverRetrofit
    fun goldSilverRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.GOLD_SILVER_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @AppScope
    @ImportExportRetrofit
    fun importExportRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.IMPORT_EXPORT_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @AppScope
    fun stockMarketService(@StockMarketRetrofit retrofit: Retrofit): StockMarketService =
        retrofit.create(
            StockMarketService::class.java
        )

    @Provides
    @AppScope
    fun upbitService(@UpbitRetrofit retrofit: Retrofit): UpbitService =
        retrofit.create(UpbitService::class.java)

    @Provides
    @AppScope
    fun currencyService(@CurrencyInterestRetrofit retrofit: Retrofit): CurrencyInterestRateService =
        retrofit.create(
            CurrencyInterestRateService::class.java
        )

    @Provides
    @AppScope
    fun commodityService(@CommodityRetrofit retrofit: Retrofit): CommodityService =
        retrofit.create(CommodityService::class.java)

    @Provides
    @AppScope
    fun importExportService(@ImportExportRetrofit retrofit: Retrofit): ImportExportService =
        retrofit.create(ImportExportService::class.java)
}
