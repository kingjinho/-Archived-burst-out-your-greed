package com.projectseoul.stockmarkettest.di.activity

import com.projectseoul.stockmarkettest.di.annotation.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(
    modules = [ActivityModule::class]
)
interface IActivityComponent {

}