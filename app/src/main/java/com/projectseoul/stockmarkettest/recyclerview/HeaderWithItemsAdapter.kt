package com.projectseoul.stockmarkettest.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.databinding.ItemHeaderWithRecyclerviewBinding
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.recyclerview.viewholders.HeaderWithItemsVH
import com.projectseoul.stockmarkettest.screens.main.ScreenMainMvc

/**
 * Created by KING JINHO on 9/15/2021
 */

class HeaderWithItemsAdapter(
    callback: DiffUtil.ItemCallback<HeaderWithItems>,
    private val seeMoreListener: HeaderWithItemsListener?,
    private val itemClickListener: ScreenMainMvc.ItemClickListener?,
    private val orientation: Int = RecyclerView.HORIZONTAL,
) : ListAdapter<HeaderWithItems, HeaderWithItemsVH>(callback) {


    override fun getItemViewType(position: Int): Int {
        return R.layout.item_header_with_recyclerview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderWithItemsVH {
        val viewHolder = HeaderWithItemsVH(
            ItemHeaderWithRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            seeMoreListener, itemClickListener
        )
        val manager = LinearLayoutManager(parent.context, orientation, false)
            .apply {
                isItemPrefetchEnabled = true
                initialPrefetchItemCount = 5
            }
        viewHolder.setLayoutManager(manager)
        return viewHolder
    }

    override fun onBindViewHolder(holder: HeaderWithItemsVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}
