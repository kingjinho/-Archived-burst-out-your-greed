package com.projectseoul.stockmarkettest.di.application

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.projectseoul.stockmarkettest.di.annotation.scope.AppScope
import com.projectseoul.stockmarkettest.network.*
import dagger.Component


@AppScope
@Component(
    modules = [ApplicationModule::class]
)
interface IApplicationComponent {

    fun application(): Application

    fun stockMarketService(): StockMarketService

    fun upbitService(): UpbitService

    fun currencyService(): CurrencyInterestRateService

    fun commodityService(): CommodityService

    fun importExportService(): ImportExportService

    fun inject(activity: AppCompatActivity)
}
