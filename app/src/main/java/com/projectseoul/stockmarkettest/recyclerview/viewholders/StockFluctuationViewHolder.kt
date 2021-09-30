package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockFluctuationBinding
import com.projectseoul.stockmarkettest.models.StockByFluctuation
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/18/2021
 */
class StockFluctuationViewHolder(
    private val binding: ItemStockFluctuationBinding,
    action: () -> Unit
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByFluctuation
        }
    }
}