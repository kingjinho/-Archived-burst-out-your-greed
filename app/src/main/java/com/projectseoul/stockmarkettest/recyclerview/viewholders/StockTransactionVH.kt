package com.projectseoul.stockmarkettest.recyclerview.viewholders

import androidx.databinding.ViewDataBinding
import com.projectseoul.stockmarkettest.databinding.ItemStockFluctuationShortBinding
import com.projectseoul.stockmarkettest.databinding.ItemStockTransactionBinding
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/18/2021
 */
class StockTransactionVH(
    private val binding: ViewDataBinding,
    action: () -> Unit
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        when(binding) {
            is ItemStockTransactionBinding -> {
                binding
            }
            else -> {
                binding as ItemStockFluctuationShortBinding
            }
        }
    }
}