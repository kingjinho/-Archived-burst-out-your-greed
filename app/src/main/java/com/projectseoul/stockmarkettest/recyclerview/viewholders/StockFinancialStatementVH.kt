package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemFinancialStatementBinding
import com.projectseoul.stockmarkettest.models.StockFinancialStatement
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/29/2021
 */
class StockFinancialStatementVH(
    private val binding: ItemFinancialStatementBinding
): BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            statement = item as StockFinancialStatement
            executePendingBindings()
        }
    }
}