package com.projectseoul.stockmarkettest.screens.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.projectseoul.stockmarkettest.di.presentation.IPresentationComponent
import com.projectseoul.stockmarkettest.models.BaseStock
import com.projectseoul.stockmarkettest.models.StockByBlockDeal
import com.projectseoul.stockmarkettest.screens.ActivityMain
import com.projectseoul.stockmarkettest.screens.BaseBottomFragment
import com.projectseoul.stockmarkettest.viewmodels.ScreenMainViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by KING JINHO on 9/14/2021
 */
class ScreenMain : BaseBottomFragment(), ScreenMainMvc.ItemClickListener {

    @Inject lateinit var viewModel: ScreenMainViewModel
    private lateinit var viewMvc: ScreenMainMvc
    private var job: Job? = null

    override fun onClick(item: Any) {
        val stockCode = when (item) {
            is BaseStock -> item.stockCode
            is StockByBlockDeal -> item.stockCode
            else -> throw IllegalArgumentException("item type should match")
        }
        val direction = ScreenMainDirections.mainToDetail(stockCode!!)
        findNavController().navigate(direction)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as ActivityMain).injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewMvc = ScreenMainMvc(inflater, container, viewLifecycleOwner)
        return viewMvc.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    override fun onResume() {
        super.onResume()
        viewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
        viewMvc.unregisterListener()
    }

    private fun fetchData() {
        job = viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.fetchData().collectLatest {
                    viewMvc.submitList(it)
                    viewMvc.changeViewVisibility(it)
                }
            }
        }
    }
}