package com.projectseoul.stockmarkettest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.projectseoul.stockmarkettest.repository.FragmentMainRepo

/**
 * Created by KING JINHO on 9/15/2021
 */
class FragmentMainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo by lazy { FragmentMainRepo(application) }

    fun fluctuation() = repo.top50ByFluctuationFlow
    fun transaction() = repo.top50ByTransactionFlow
    fun marketCap() = repo.top50ByMarketCapFlow
    fun upperLowerLimit() = repo.upperLowerLimitFlow
    fun foreigner() = repo.top50ByForeignerFlow
    fun turnover() = repo.top50ByTurnoverFlow
    fun blockDeal() = repo.blockDealFlow
    fun oil() = repo.crudeOilFlow
    fun indices() = repo.balticIndexFlow
    fun cornWheatSoyBean() = repo.cornWheatSoyBeanFlow
    fun monthlyTrading() = repo.importExportFlow

}