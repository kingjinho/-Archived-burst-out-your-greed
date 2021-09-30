package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemOilShortBinding
import com.projectseoul.stockmarkettest.models.CrudeOil
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class OilShortViewHolder(
    private val binding: ItemOilShortBinding,
) : BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            oil = item as CrudeOil
            executePendingBindings()
        }
    }
}