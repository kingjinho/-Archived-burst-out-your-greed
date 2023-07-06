package com.projectseoul.stockmarkettest.di.activity

import com.projectseoul.stockmarkettest.di.annotation.scope.ActivityScope
import com.projectseoul.stockmarkettest.screens.detail.ScreenStockDetail
import com.projectseoul.stockmarkettest.screens.main.ScreenMain
import com.projectseoul.stockmarkettest.screens.splash.ScreenSplash
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [ActivityModule::class]
)
interface IActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): IActivityComponent
    }

    fun inject(screen: ScreenMain)
    fun inject(screen: ScreenStockDetail)
    fun inject(screen: ScreenSplash)
}