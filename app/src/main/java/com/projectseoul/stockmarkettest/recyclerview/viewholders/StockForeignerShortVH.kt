package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockForeignerShortBinding
import com.projectseoul.stockmarkettest.models.StockByForeigner
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockForeignerShortVH(
    private val binding: ItemStockForeignerShortBinding,
    private val listener: ItemClickListener
): BaseViewHolder(binding){
    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByForeigner
            executePendingBindings()
        }

        itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}