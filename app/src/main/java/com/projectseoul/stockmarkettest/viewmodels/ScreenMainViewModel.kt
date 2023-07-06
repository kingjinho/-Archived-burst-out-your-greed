package com.projectseoul.stockmarkettest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.projectseoul.stockmarkettest.repository.ScreenMainRepo
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by KING JINHO on 9/15/2021
 */

class ScreenMainViewModelFactory(
    private val repo: ScreenMainRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ScreenMainViewModel::class.java)) {
            ScreenMainViewModel(repo) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}

class ScreenMainViewModel @Inject constructor(private val repo: ScreenMainRepo) : ViewModel() {

    fun fetchData() = flow {
        val result = withContext(viewModelScope.coroutineContext) {
            val fluctuation = async {
                repo.getTop50ByFluctuation()
            }
            val transaction = async {
                repo.getTop50ByTransaction()
            }
            val marketCap = async {
                repo.top50ByMarketCap()
            }
            val upperLowerLimit = async {
                repo.getUpperLowerLimit()
            }
            val foreigner = async {
                repo.getTop50ByForeigner()
            }
            val turnover = async {
                repo.getTop50ByTurnover()
            }
            val blockDeal = async {
                repo.getBlockDealFlow()
            }
            val oil = async {
                repo.getCrudeOil()
            }
            val balticIndices = async {
                repo.getBalticIndex()
            }
            val cornWheatSoyBean = async {
                repo.getCornWheatSoyBean()
            }
            val monthlyTrading = async {
                repo.getImportExport()
            }

            listOf(
                fluctuation.await(),
                transaction.await(),
                marketCap.await(),
                upperLowerLimit.await(),
                foreigner.await(),
                turnover.await(),
                blockDeal.await(),
                oil.await(),
                balticIndices.await(),
                cornWheatSoyBean.await(),
                monthlyTrading.await()
            )
        }

        emit(result)
    }

}