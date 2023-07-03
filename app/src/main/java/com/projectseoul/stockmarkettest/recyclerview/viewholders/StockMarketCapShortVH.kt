package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockMarketCapShortBinding
import com.projectseoul.stockmarkettest.models.StockByMarketCap
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.screens.main.ScreenMainMvc

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockMarketCapShortVH(
    private val binding: ItemStockMarketCapShortBinding,
    private val listener: ScreenMainMvc.ItemClickListener
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByMarketCap
            executePendingBindings()
        }

        itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}