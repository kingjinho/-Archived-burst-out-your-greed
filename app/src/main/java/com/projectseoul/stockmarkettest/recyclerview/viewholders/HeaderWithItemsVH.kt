package com.projectseoul.stockmarkettest.recyclerview.viewholders

import android.graphics.Rect
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.projectseoul.stockmarkettest.databinding.ItemHeaderWithRecyclerviewBinding
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.recyclerview.HeaderWithItemsListener
import com.projectseoul.stockmarkettest.recyclerview.ItemClickListener
import com.projectseoul.stockmarkettest.recyclerview.ItemRecyclerViewAdapter

/**
 * Created by KING JINHO on 9/15/2021
 */
class HeaderWithItemsVH(
    private val binding: ItemHeaderWithRecyclerviewBinding,
    private val seeMoreClickListener: HeaderWithItemsListener?,
    private val itemClickListener: ItemClickListener?,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HeaderWithItems) {
        binding.header.setText(item.titleRes)
        binding.subHeader.isVisible = item.enableDelay

        binding.seeMore.setOnClickListener {
            seeMoreClickListener?.onClick(item)
        }

        val adapter = createAdapter(item)
        binding.list.adapter = adapter
        if (binding.list.itemDecorationCount == 0) {
            binding.list.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    if (parent.getChildAdapterPosition(view) != adapter.itemCount - 1) {
                        outRect.right += 32
                    }
                }
            })
        }
    }

    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager) {
        binding.list.layoutManager = layoutManager
    }

    private fun createAdapter(item: HeaderWithItems) =
        when (item) {
            is HeaderWithFluctuation -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { old, new ->
                        return@ItemRecyclerViewAdapter old == new
                    },
                    areContentsTheSame = { old, new ->
                        return@ItemRecyclerViewAdapter (old.stockCode == new.stockCode
                                && old.closing == new.closing
                                && old.volume == new.volume
                                && old.amount == new.amount)
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithTransaction -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithMarketCap -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithUpperLowerLimit -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithForeigner -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithTurnover -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithBlockDeal -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                    },
                    listener = itemClickListener
                )
            }
            is HeaderWithGrains -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.date == newItem.date
                    })
            }
            is HeaderWithOil -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.date == newItem.date
                    })
            }
            is HeaderWithBalticIndices -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.date == newItem.date
                    })
            }
            is HeaderWithBasicInfo -> {
                ItemRecyclerViewAdapter(
                    items = item.items,
                    areItemsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem == newItem
                    },
                    areContentsTheSame = { oldItem, newItem ->
                        return@ItemRecyclerViewAdapter oldItem.stockCode == newItem.stockCode
                    })
            }
            is HeaderWithSingleLineChart -> ItemRecyclerViewAdapter(
                items = item.items,
                areItemsTheSame = { oldItem, newItem ->
                    return@ItemRecyclerViewAdapter oldItem == newItem
                },
                areContentsTheSame = { oldItem, newItem ->
                    return@ItemRecyclerViewAdapter oldItem.size == newItem.size
                })
            is HeaderWithStatement -> ItemRecyclerViewAdapter(
                items = item.items,
                areItemsTheSame = { oldItem, newItem ->
                    return@ItemRecyclerViewAdapter oldItem == newItem
                },
                areContentsTheSame = { oldItem, newItem ->
                    return@ItemRecyclerViewAdapter oldItem.equals(newItem)
                })
            is HeaderWithMonthlyTrading -> ItemRecyclerViewAdapter(
                items = item.items,
                areItemsTheSame = { oldItem, newItem ->
                    return@ItemRecyclerViewAdapter oldItem == newItem
                },
                areContentsTheSame = { oldItem, newItem ->
                    return@ItemRecyclerViewAdapter oldItem.period == newItem.period
                })
        }
}