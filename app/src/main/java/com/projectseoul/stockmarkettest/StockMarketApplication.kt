package com.projectseoul.stockmarkettest

import android.app.Application
import com.projectseoul.stockmarkettest.di.application.AppModule
import com.projectseoul.stockmarkettest.di.application.DaggerIAppComponent
import com.projectseoul.stockmarkettest.di.application.IAppComponent

/**
 * Created by KING JINHO on 5/28/2022
 */
class StockMarketApplication : Application() {

    val appComponent: IAppComponent by lazy {
        DaggerIAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}
