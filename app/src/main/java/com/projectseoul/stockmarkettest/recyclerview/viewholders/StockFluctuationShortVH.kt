package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockFluctuationShortBinding
import com.projectseoul.stockmarkettest.models.StockByFluctuation
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.screens.main.ScreenMainMvc

/**
 * Created by KING JINHO on 9/18/2021
 */
class StockFluctuationShortVH(
    private val binding: ItemStockFluctuationShortBinding,
    private val listener: ScreenMainMvc.ItemClickListener
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByFluctuation
            executePendingBindings()
        }

        itemView.setOnClickListener { listener.onClick(item) }
    }
}