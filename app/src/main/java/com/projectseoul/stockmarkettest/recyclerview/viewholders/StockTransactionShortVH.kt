package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemStockTransactionShortBinding
import com.projectseoul.stockmarkettest.models.StockByTransaction
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.screens.main.ScreenMainMvc

/**
 * Created by KING JINHO on 9/18/2021
 */
class StockTransactionShortVH(
    private val binding: ItemStockTransactionShortBinding,
    private val listener: ScreenMainMvc.ItemClickListener
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            stock = item as StockByTransaction
            executePendingBindings()
        }

        itemView.setOnClickListener {
            listener.onClick(item)
        }
    }
}