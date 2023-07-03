package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockForeignerShortBinding
import com.projectseoul.stockmarkettest.models.StockByForeigner
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.screens.main.ScreenMainMvc

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockForeignerShortVH(
    private val binding: ItemStockForeignerShortBinding,
    private val listener: ScreenMainMvc.ItemClickListener
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