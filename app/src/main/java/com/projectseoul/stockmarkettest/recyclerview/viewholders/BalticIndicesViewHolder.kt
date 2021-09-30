package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemBalticIndexBinding
import com.projectseoul.stockmarkettest.models.BDIIndex
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/27/2021
 */
class BalticIndicesViewHolder(
    private val binding: ItemBalticIndexBinding,
    private val action: () -> Unit
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            indices = item as BDIIndex
            executePendingBindings()
        }
        itemView.setOnClickListener { action.invoke() }
    }
}