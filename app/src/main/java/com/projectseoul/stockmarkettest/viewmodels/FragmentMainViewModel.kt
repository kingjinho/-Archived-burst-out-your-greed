package com.projectseoul.stockmarkettest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.repository.FragmentMainRepo
import kotlinx.coroutines.flow.*

/**
 * Created by KING JINHO on 9/15/2021
 */
class FragmentMainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo by lazy { FragmentMainRepo(application) }

    fun fluctuation() = repo.top50ByFluctuation
    fun transaction() = repo.top50ByTransaction
    fun marketCap() = repo.top50ByMarketCap
    fun upperLowerLimit() = repo.upperLowerLimit
    fun foreigner() = repo.top50ByForeigner
    fun turnover() = repo.top50ByTurnover
    fun blockDeal() = repo.blockDealFlow
    fun oil() = repo.crudeOil
    fun indices() = repo.balticIndex
    fun cornWheatSoyBean() = repo.cornWheatSoyBean


}