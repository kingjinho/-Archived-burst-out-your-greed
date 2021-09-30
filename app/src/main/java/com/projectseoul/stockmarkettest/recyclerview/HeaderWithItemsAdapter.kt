package com.projectseoul.stockmarkettest.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.projectseoul.stockmarkettest.R
import com.projectseoul.stockmarkettest.databinding.ItemHeaderWithRecyclerviewBinding
import com.projectseoul.stockmarkettest.models.HeaderWithItems
import com.projectseoul.stockmarkettest.recyclerview.viewholders.HeaderWithItemsViewHolder

/**
 * Created by KING JINHO on 9/15/2021
 */

class HeaderWithItemsAdapter(
    callback: DiffUtil.ItemCallback<HeaderWithItems>,
    private val seeMoreListener: HeaderWithItemsListener?,
    private val itemClickListener: ItemClickListener?,
    private val orientation: Int = RecyclerView.HORIZONTAL,
) : ListAdapter<HeaderWithItems, HeaderWithItemsViewHolder>(callback) {


    override fun getItemViewType(position: Int): Int {
        return R.layout.item_header_with_recyclerview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderWithItemsViewHolder {
        val viewHolder = HeaderWithItemsViewHolder(
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
                initialPrefetchItemCount = 3
            }
        viewHolder.setLayoutManager(manager)
        return viewHolder
    }

    override fun onBindViewHolder(holder: HeaderWithItemsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }


}
