package com.projectseoul.stockmarkettest.recyclerview.viewholders

import com.projectseoul.stockmarkettest.databinding.ItemGrainShortBinding
import com.projectseoul.stockmarkettest.models.Grain
import com.projectseoul.stockmarkettest.recyclerview.BaseViewHolder
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener

/**
 * Created by KING JINHO on 9/27/2021
 */
class GrainShortVH(
    private val binding: ItemGrainShortBinding,
) : BaseViewHolder(binding) {

    override fun bind(item: Any) {
        binding.run {
            grain = item as Grain
            executePendingBindings()
        }
    }
}