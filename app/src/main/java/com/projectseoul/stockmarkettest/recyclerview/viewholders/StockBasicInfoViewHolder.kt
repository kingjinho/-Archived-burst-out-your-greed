package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockBaseInformationBinding
import com.projectseoul.stockmarkettest.models.StockBaseInfo
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/29/2021
 */
class StockBasicInfoViewHolder(
    private val binding: ItemStockBaseInformationBinding
) : BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            info = item as StockBaseInfo
            executePendingBindings()
        }
    }
}