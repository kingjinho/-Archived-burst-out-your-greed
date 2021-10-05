package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockForeignerBinding
import com.projectseoul.stockmarkettest.databinding.ItemStockForeignerShortBinding
import com.projectseoul.stockmarkettest.models.StockByForeigner
import com.projectseoul.stockmarkettest.models.StockByMarketCap
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockForeignerVH(
    private val binding: ItemStockForeignerBinding,
    private val action: () -> Unit
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByForeigner
            executePendingBindings()
        }

        itemView.setOnClickListener {
            action.invoke()
        }
    }
}