package com.projectseoul.stockmarkettest

import android.app.Application
import com.projectseoul.stockmarkettest.di.application.ApplicationModule
import com.projectseoul.stockmarkettest.di.application.DaggerIApplicationComponent
import com.projectseoul.stockmarkettest.di.application.IApplicationComponent

/**
 * Created by KING JINHO on 5/28/2022
 */
class StockMarketApplication : Application() {

    val appComponent: IApplicationComponent by lazy {
        DaggerIApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}
