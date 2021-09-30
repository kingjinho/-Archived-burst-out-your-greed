package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemBalticIndexShortBinding
import com.projectseoul.stockmarkettest.models.BDIIndex
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class BalticIndicesShortViewHolder(
    private val binding: ItemBalticIndexShortBinding,
) : BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            indices = item as BDIIndex
            executePendingBindings()
        }
    }
}