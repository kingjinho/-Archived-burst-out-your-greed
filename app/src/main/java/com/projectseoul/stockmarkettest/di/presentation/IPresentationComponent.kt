package com.projectseoul.stockmarkettest.di.presentation

import com.projectseoul.stockmarkettest.screens.detail.ScreenStockDetail
import com.projectseoul.stockmarkettest.screens.main.ScreenMain
import com.projectseoul.stockmarkettest.screens.splash.ScreenSplash
import dagger.Subcomponent

@Subcomponent(
    modules = [PresentationModule::class]
)
interface IPresentationComponent {

    fun inject(screen: ScreenMain)
    fun inject(screen: ScreenStockDetail)
    fun inject(screen: ScreenSplash)

}