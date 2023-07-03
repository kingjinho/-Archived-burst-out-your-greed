package com.projectseoul.stockmarkettest.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectseoul.stockmarkettest.databinding.FragmentMainBinding
import com.projectseoul.stockmarkettest.models.BaseStock
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.models.StockByBlockDeal
import com.projectseoul.stockmarkettest.recyclerview.HeaderWithItemsAdapter
import com.projectseoul.stockmarkettest.recyclerview.HeaderWithItemsListener
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener
import com.projectseoul.stockmarkettest.screens.BaseBottomFragment
import com.projectseoul.stockmarkettest.screens.FragmentMainDirections
import com.projectseoul.stockmarkettest.viewmodels.FragmentMainViewModel
import kotlinx.coroutines.Job

/**
 * Created by KING JINHO on 9/14/2021
 */
class ScreenMain : BaseBottomFragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this).get(FragmentMainViewModel::class.java)
    }
    var job: Job? = null


    private val adapter by lazy {
        HeaderWithItemsAdapter(
            object : DiffUtil.ItemCallback<HeaderWithItems>() {
                override fun areItemsTheSame(
                    oldItem: HeaderWithItems,
                    newItem: HeaderWithItems
                ): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(
                    oldItem: HeaderWithItems,
                    newItem: HeaderWithItems
                ): Boolean {
                    return oldItem.titleRes == newItem.titleRes
                }
            },
            object : HeaderWithItemsListener {
                override fun onClick(item: HeaderWithItems) {
                    //TODO: Need to figure out setting model first
                }
            },
            object : ItemClickListener {
                override fun onClick(item: Any) {
                    val stockCode = when (item) {
                        is BaseStock -> item.stockCode
                        is StockByBlockDeal -> item.stockCode
                        else -> throw IllegalArgumentException("item type should match")
                    }
                    val direction = FragmentMainDirections.mainToDetail(stockCode!!)
                    findNavController().navigate(direction)
                }
            })
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.list.adapter = adapter
        binding.list.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false).apply {
                isItemPrefetchEnabled = true
                initialPrefetchItemCount = 5
            }

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }


    private fun fetchData() {
        job = viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            val listItems = mutableListOf<HeaderWithItems>()

            viewModel.fluctuation().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.transaction().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.marketCap().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.upperLowerLimit().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.foreigner().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.turnover().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.blockDeal().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.cornWheatSoyBean().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.oil().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.indices().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }
            viewModel.monthlyTrading().collect {
                if (it.items.isNotEmpty()) {
                    listItems.add(it)
                }
            }

            adapter.submitList(listItems)
            binding.list.isVisible = listItems.isNotEmpty()
            binding.msg.isVisible = listItems.isEmpty()
            binding.progressBar.isVisible = listItems.isEmpty()

        }
    }
}