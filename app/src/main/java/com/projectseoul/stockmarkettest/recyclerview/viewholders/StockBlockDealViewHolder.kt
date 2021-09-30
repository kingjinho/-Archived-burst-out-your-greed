package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockBlockDealBinding
import com.projectseoul.stockmarkettest.models.StockByBlockDeal
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockBlockDealViewHolder(
    private val binding: ItemStockBlockDealBinding,
    private val action: () -> Unit
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByBlockDeal
            executePendingBindings()
        }
        itemView.setOnClickListener { action.invoke() }
    }
}