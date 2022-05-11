package com.projectseoul.stockmarkettest.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by KING JINHO on 9/15/2021
 */

abstract class BaseViewHolder(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: Any)

}