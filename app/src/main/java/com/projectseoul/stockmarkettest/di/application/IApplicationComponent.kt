package com.projectseoul.stockmarkettest.di.application

import com.projectseoul.stockmarkettest.di.activity.ActivityModule
import com.projectseoul.stockmarkettest.di.activity.IActivityComponent
import com.projectseoul.stockmarkettest.di.annotation.scope.AppScope
import dagger.Component


@AppScope
@Component(modules = [ApplicationModule::class])
interface IApplicationComponent {

    fun newActivityComponent(module:ActivityModule): IActivityComponent
}
