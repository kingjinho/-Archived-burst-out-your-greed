package com.projectseoul.stockmarkettest.di.application

import com.projectseoul.stockmarkettest.di.annotation.scope.AppScope
import com.projectseoul.stockmarkettest.network.*
import dagger.Component


@AppScope
@Component(
    modules = [AppModule::class]
)
interface IAppComponent {

    @AppScope
    fun stockMarketService(): StockMarketService

    @AppScope
    fun upbitService(): UpbitService

    @AppScope
    fun currencyService(): CurrencyInterestRateService

    @AppScope
    fun commodityService(): CommodityService

    @AppScope
    fun importExportService(): ImportExportService
}
