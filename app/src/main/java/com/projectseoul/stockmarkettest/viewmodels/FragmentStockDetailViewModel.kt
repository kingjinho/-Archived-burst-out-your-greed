package com.projectseoul.stockmarkettest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.repository.FragmentStockDetailRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

/**
 * Created by KING JINHO on 9/28/2021
 */
class FragmentStockDetailViewModel(application: Application, private val stockCode: String) :
    AndroidViewModel(application) {

    class StockDetailViewModelFactory(
        private val application: Application, private val stockCode: String
    ) : ViewModelProvider.AndroidViewModelFactory(application) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FragmentStockDetailViewModel(application, stockCode) as T
        }
    }

    private val repo by lazy { FragmentStockDetailRepo(application) }
    private var kd: String? = null
    private var data: List<HeaderWithItems>? = null

    init {
        getKdValue()
    }

    private fun getKdValue() {
        viewModelScope.async(Dispatchers.IO) {
            val result = repo.getKD(stockCode)
            withContext(Dispatchers.Main) {
                kd = result
            }
        }
    }

    fun fetch() = flow {
        if (data == null) {
            val result = mutableListOf<HeaderWithItems>()
            if (kd == null) {
                kd = repo.getKD(stockCode)
            }
            if(kd != null) {
                val baseInfo = repo.getBaseInfo(kd!!)
                val quotation = repo.getQuotationHistory(kd!!)
                val statement = repo.getStatement(kd!!)

                if (baseInfo.items.isNotEmpty()) {
                    result.add(baseInfo)
                }
                if (quotation.isNotEmpty()) {
                    quotation.forEach {
                        result.add(it)
                    }
                }
                if (statement.items.isNotEmpty()) {
                    result.add(statement)
                }
            }
            data = result
        }
        emit(data)
    }.flowOn(Dispatchers.IO)
}
