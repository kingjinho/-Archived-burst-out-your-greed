package com.projectseoul.stockmarkettest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.projectseoul.stockmarkettest.repository.FragmentMainRepo
import kotlinx.coroutines.flow.flow

/**
 * Created by KING JINHO on 9/15/2021
 */
class FragmentMainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo by lazy { FragmentMainRepo(application) }

    fun fetchData() = flow {

        val fluctuation = repo.getTop50ByFluctuation()
        val transaction = repo.getTop50ByTransaction()
        val marketCap = repo.top50ByMarketCap()
        val upperLowerLimit = repo.getUpperLowerLimit()
        val foreigner = repo.getTop50ByForeigner()
        val turnover = repo.getTop50ByTurnover()
        val blockDeal = repo.getBlockDealFlow()
        val oil = repo.getCrudeOil()
        val balticIndices = repo.getBalticIndex()
        val cornWheatSoyBean = repo.getCornWheatSoyBean()
        val monthlyTrading = repo.getImportExport()

        emit(listOf(
            fluctuation, transaction, marketCap, upperLowerLimit, foreigner,
            turnover, blockDeal, oil, balticIndices, cornWheatSoyBean, monthlyTrading
        ))
    }

}