package com.projectseoul.stockmarkettest.viewmodels

import androidx.lifecycle.AndroidViewModel
import com.projectseoul.stockmarkettest.repository.FragmentSplashRepo
import kotlinx.coroutines.flow.flow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by KING JINHO on 9/14/2021
 */
class FragmentSplashViewModel @Inject constructor(
    private val repo: FragmentSplashRepo
) : AndroidViewModel(repo.application) {

    suspend fun refreshData() = flow {
        emit(repo.refreshData())
    }

    fun shouldInvalidateLocalDatabase(): Boolean {
        val lastUpdateDateInMilliSeconds = repo.getLastUpdateDateInMilliSeconds()
        return TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - lastUpdateDateInMilliSeconds) > 0
    }

    fun updateLastUpdateDateInMilliSeconds() {
        repo.updateLastUpdateDateInMilliSeconds()
    }

}