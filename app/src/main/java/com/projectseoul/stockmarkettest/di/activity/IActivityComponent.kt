package com.projectseoul.stockmarkettest.di.activity

import com.projectseoul.stockmarkettest.di.annotation.scope.ActivityScope
import com.projectseoul.stockmarkettest.di.presentation.IPresentationComponent
import com.projectseoul.stockmarkettest.di.presentation.PresentationModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [ActivityModule::class]
)
interface IActivityComponent {

    fun newPresentationComponent(module: PresentationModule): IPresentationComponent
}