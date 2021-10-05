package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemMonthlyTradingBinding
import com.projectseoul.stockmarkettest.models.MonthlyTrading
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 10/5/2021
 */
class MonthlyTradingVH(
    private val binding: ItemMonthlyTradingBinding
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            trading = item as MonthlyTrading
            executePendingBindings()
        }
    }
}