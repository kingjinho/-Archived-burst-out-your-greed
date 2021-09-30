package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockUpperLowerShortBinding
import com.projectseoul.stockmarkettest.models.StockByUpperLowerLimit
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockUpperLowerShortViewHolder(
    private val binding: ItemStockUpperLowerShortBinding,
    private val listener: ItemClickListener
): BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByUpperLowerLimit
            executePendingBindings()
        }

        itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}