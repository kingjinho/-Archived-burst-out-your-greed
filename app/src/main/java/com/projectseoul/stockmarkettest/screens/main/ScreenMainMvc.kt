package com.projectseoul.stockmarkettest.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectseoul.stockmarkettest.databinding.FragmentMainBinding
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.recyclerview.HeaderWithItemsAdapter
import com.projectseoul.stockmarkettest.recyclerview.HeaderWithItemsListener

class ScreenMainMvc(
    layoutInflater: LayoutInflater,
    parent: ViewGroup? = null,
    viewLifecycleOwner: LifecycleOwner
) {

    interface ItemClickListener {
        fun onClick(item: Any)
    }

    val binding: FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater, parent, false)
        .apply {
            lifecycleOwner = viewLifecycleOwner
        }
    val rootView: View = binding.root
    private val context = binding.root.context
    private var listener: ItemClickListener? = null

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
                    listener?.onClick(item)
                }
            })
    }

    init {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.list.apply {
            adapter = this@ScreenMainMvc.adapter
            layoutManager =
                LinearLayoutManager(this@ScreenMainMvc.context).apply {
                    isItemPrefetchEnabled = true
                    initialPrefetchItemCount = 5
                }
        }
    }

    fun registerListener(listener: ItemClickListener) {
        this.listener = listener
    }

    fun unregisterListener() {
        listener = null
    }

    fun submitList(listItems: List<HeaderWithItems>) {
        adapter.submitList(listItems)
    }

    fun changeViewVisibility(listItems: List<HeaderWithItems>) {
        binding.list.isVisible = listItems.isNotEmpty()
        binding.msg.isVisible = listItems.isEmpty()
        binding.progressBar.isVisible = listItems.isEmpty()
    }

}