package com.projectseoul.stockmarkettest.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.projectseoul.stockmarkettest.repository.FragmentSplashRepo
import kotlinx.coroutines.flow.flow

/**
 * Created by KING JINHO on 9/14/2021
 */
class FragmentSplashViewModel(application: Application) : AndroidViewModel(application) {

    private val repo by lazy { FragmentSplashRepo(application) }

    suspend fun refreshData() = flow {
        emit(repo.refreshData())
    }
}