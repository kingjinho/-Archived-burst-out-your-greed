package com.projectseoul.stockmarkettest.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.databinding.FragmentStockDetailBinding
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.recyclerview.HeaderWithItemsAdapter
import com.projectseoul.stockmarkettest.screens.FragmentStockDetailArgs
import com.projectseoul.stockmarkettest.viewmodels.FragmentStockDetailViewModel
import kotlinx.coroutines.Job

/**
 * Created by KING JINHO on 9/28/2021
 */
class ScreenStockDetail : Fragment() {
    private val args: FragmentStockDetailArgs by navArgs()
    private val viewModel: FragmentStockDetailViewModel by viewModels {
        FragmentStockDetailViewModel.StockDetailViewModelFactory(
            requireActivity().application, args.stockCode
        )
    }

    private val parentAdapter by lazy {
        HeaderWithItemsAdapter(object : DiffUtil.ItemCallback<HeaderWithItems>() {
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
        },null, null, RecyclerView.VERTICAL)
    }

    lateinit var binding: FragmentStockDetailBinding
    private var job: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStockDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.list.adapter = parentAdapter
        binding.list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }

    private fun fetchData() {
        binding.list.isVisible = false
        binding.retry.isVisible = false
        binding.progressBar.isVisible = true

        job = viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.fetch().collect {
                val isFailed = it.isNullOrEmpty()
                if (isFailed) {
                    Toast.makeText(context, R.string.toast_data_empty, Toast.LENGTH_LONG).show()
                } else {
                    parentAdapter.submitList(it)
                }
                binding.list.isVisible = !isFailed
                binding.progressBar.isVisible = false
                binding.retry.isVisible = isFailed
            }
        }
    }

}