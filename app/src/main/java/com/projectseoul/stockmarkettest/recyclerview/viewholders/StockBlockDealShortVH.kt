package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockBlockDealShortBinding
import com.projectseoul.stockmarkettest.models.StockByBlockDeal
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockBlockDealShortVH(
    private val binding: ItemStockBlockDealShortBinding,
    private val listener: ItemClickListener
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByBlockDeal
            executePendingBindings()
        }
        itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}