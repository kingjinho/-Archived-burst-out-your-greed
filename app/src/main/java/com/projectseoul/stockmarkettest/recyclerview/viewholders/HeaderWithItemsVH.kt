package com.projectseoul.stockmarkettest.recyclerview.viewholders

import android.graphics.Rect
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
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
                    item.items,
                    object : DiffUtil.ItemCallback<StockByFluctuation>() {
                        override fun areItemsTheSame(
                            oldItem: StockByFluctuation,
                            newItem: StockByFluctuation
                        ) = oldItem == newItem

                        override fun areContentsTheSame(
                            oldItem: StockByFluctuation,
                            newItem: StockByFluctuation
                        ) = oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    },
                    itemClickListener
                )
            }
            is HeaderWithTransaction -> {
                ItemRecyclerViewAdapter(
                    item.items,
                    object : DiffUtil.ItemCallback<StockByTransaction>() {
                        override fun areItemsTheSame(
                            oldItem: StockByTransaction,
                            newItem: StockByTransaction
                        ) = oldItem == newItem


                        override fun areContentsTheSame(
                            oldItem: StockByTransaction,
                            newItem: StockByTransaction
                        ) = oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    }, itemClickListener
                )
            }
            is HeaderWithMarketCap -> {
                ItemRecyclerViewAdapter(
                    item.items,
                    object : DiffUtil.ItemCallback<StockByMarketCap>() {
                        override fun areItemsTheSame(
                            oldItem: StockByMarketCap,
                            newItem: StockByMarketCap
                        ) = oldItem == newItem


                        override fun areContentsTheSame(
                            oldItem: StockByMarketCap,
                            newItem: StockByMarketCap
                        ) = oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    }, itemClickListener
                )
            }
            is HeaderWithUpperLowerLimit -> {
                ItemRecyclerViewAdapter(
                    item.items,
                    object : DiffUtil.ItemCallback<StockByUpperLowerLimit>() {
                        override fun areItemsTheSame(
                            oldItem: StockByUpperLowerLimit,
                            newItem: StockByUpperLowerLimit
                        ) = oldItem == newItem


                        override fun areContentsTheSame(
                            oldItem: StockByUpperLowerLimit,
                            newItem: StockByUpperLowerLimit
                        ) = oldItem.stockCode == newItem.stockCode
                                && oldItem.closing == newItem.closing
                                && oldItem.volume == newItem.volume
                                && oldItem.amount == newItem.amount
                    }, itemClickListener
                )
            }
            is HeaderWithForeigner -> {
                ItemRecyclerViewAdapter(
                    item.items,
                    object : DiffUtil.ItemCallback<StockByForeigner>() {
                        override fun areItemsTheSame(
                            oldItem: StockByForeigner,
                            newItem: StockByForeigner
                        ) = oldItem == newItem


                        override fun areContentsTheSame(
                            oldItem: StockByForeigner,
                            newItem: StockByForeigner
                        ) = oldItem.stockCode == newItem.stockCode
                    }, itemClickListener
                )
            }
            is HeaderWithTurnover -> {
                ItemRecyclerViewAdapter(
                    item.items,
                    object : DiffUtil.ItemCallback<StockByTurnover>() {
                        override fun areItemsTheSame(
                            oldItem: StockByTurnover,
                            newItem: StockByTurnover
                        ) = oldItem == newItem


                        override fun areContentsTheSame(
                            oldItem: StockByTurnover,
                            newItem: StockByTurnover
                        ) = oldItem.stockCode == newItem.stockCode
                    }, itemClickListener
                )
            }
            is HeaderWithBlockDeal -> {
                ItemRecyclerViewAdapter(
                    item.items,
                    object : DiffUtil.ItemCallback<StockByBlockDeal>() {
                        override fun areItemsTheSame(
                            oldItem: StockByBlockDeal,
                            newItem: StockByBlockDeal
                        ) = oldItem == newItem


                        override fun areContentsTheSame(
                            oldItem: StockByBlockDeal,
                            newItem: StockByBlockDeal
                        ) = oldItem.stockCode == newItem.stockCode
                    }, itemClickListener
                )
            }
            is HeaderWithGrains -> {
                ItemRecyclerViewAdapter(item.items,
                    object : DiffUtil.ItemCallback<Grain>() {
                        override fun areItemsTheSame(
                            oldItem: Grain,
                            newItem: Grain
                        ) = oldItem == newItem

                        override fun areContentsTheSame(
                            oldItem: Grain,
                            newItem: Grain
                        ) = oldItem.date == newItem.date
                    })
            }
            is HeaderWithOil -> {
                ItemRecyclerViewAdapter(item.items,
                    object : DiffUtil.ItemCallback<CrudeOil>() {
                        override fun areItemsTheSame(
                            oldItem: CrudeOil,
                            newItem: CrudeOil
                        ) = oldItem == newItem

                        override fun areContentsTheSame(
                            oldItem: CrudeOil,
                            newItem: CrudeOil
                        ) = oldItem.date == newItem.date
                    })
            }
            is HeaderWithBalticIndices -> {
                ItemRecyclerViewAdapter(item.items,
                    object : DiffUtil.ItemCallback<BDIIndex>() {
                        override fun areItemsTheSame(
                            oldItem: BDIIndex,
                            newItem: BDIIndex
                        ) = oldItem == newItem

                        override fun areContentsTheSame(
                            oldItem: BDIIndex,
                            newItem: BDIIndex
                        ) = oldItem.date == newItem.date
                    })
            }
            is HeaderWithBasicInfo -> {
                ItemRecyclerViewAdapter(item.items,
                    object : DiffUtil.ItemCallback<StockBaseInfo>() {
                        override fun areItemsTheSame(
                            oldItem: StockBaseInfo,
                            newItem: StockBaseInfo
                        ) = oldItem == newItem

                        override fun areContentsTheSame(
                            oldItem: StockBaseInfo,
                            newItem: StockBaseInfo
                        ) = oldItem.stockCode == newItem.stockCode
                    })
            }
            is HeaderWithSingleLineChart -> ItemRecyclerViewAdapter(item.items,
                object : DiffUtil.ItemCallback<List<SingleLineChart>>() {
                    override fun areItemsTheSame(
                        oldItem: List<SingleLineChart>,
                        newItem: List<SingleLineChart>
                    ) = oldItem == newItem

                    override fun areContentsTheSame(
                        oldItem: List<SingleLineChart>,
                        newItem: List<SingleLineChart>
                    ) = oldItem.size == newItem.size
                })
            is HeaderWithStatement -> ItemRecyclerViewAdapter(item.items,
                object : DiffUtil.ItemCallback<StockFinancialStatement>() {
                    override fun areItemsTheSame(
                        oldItem: StockFinancialStatement,
                        newItem: StockFinancialStatement
                    ) = oldItem == newItem

                    override fun areContentsTheSame(
                        oldItem: StockFinancialStatement,
                        newItem: StockFinancialStatement
                    ) = oldItem.equals(newItem)
                })
            is HeaderWithMonthlyTrading -> ItemRecyclerViewAdapter(item.items,
                object : DiffUtil.ItemCallback<MonthlyTrading>() {
                    override fun areItemsTheSame(
                        oldItem: MonthlyTrading,
                        newItem: MonthlyTrading
                    ) = oldItem == newItem

                    override fun areContentsTheSame(
                        oldItem: MonthlyTrading,
                        newItem: MonthlyTrading
                    ) = oldItem.period == newItem.period
                })
        }
}