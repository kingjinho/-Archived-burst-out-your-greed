package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockTurnoverShortBinding
import com.projectseoul.stockmarkettest.models.StockByTurnover
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockTurnoverShortViewHolder(
    private val binding: ItemStockTurnoverShortBinding,
    private val listener: ItemClickListener
): BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByTurnover
            executePendingBindings()
        }

        itemView.setOnClickListener { listener.onClick(item)}
    }
}