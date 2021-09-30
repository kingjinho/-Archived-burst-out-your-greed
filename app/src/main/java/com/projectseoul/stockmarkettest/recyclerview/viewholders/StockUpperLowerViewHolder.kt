package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockUpperLowerBinding
import com.projectseoul.stockmarkettest.models.StockByUpperLowerLimit
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/27/2021
 */
class StockUpperLowerViewHolder(
    private val binding: ItemStockUpperLowerBinding,
    private val action: () -> Unit
) : BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByUpperLowerLimit
            executePendingBindings()
        }

        itemView.setOnClickListener {
            action.invoke()
        }
    }
}