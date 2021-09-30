package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemGrainBinding
import com.projectseoul.stockmarkettest.models.Grain
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder

/**
 * Created by KING JINHO on 9/27/2021
 */
class GrainViewHolder(
    private val binding: ItemGrainBinding,
    private val action: () -> Unit
): BaseViewHolder(binding) {
    override fun bind(item: Any) {
        binding.run {
            grain = item as Grain
            executePendingBindings()
        }
        itemView.setOnClickListener { action.invoke() }
    }
}