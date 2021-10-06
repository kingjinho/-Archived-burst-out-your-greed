package com.projectseoul.stockmarkettest.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.utils.Const
import java.lang.IllegalArgumentException

/**
 * Created by KING JINHO on 9/18/2021
 */
class ItemRecyclerViewAdapter<T : Any>(
    private val items: List<T>,
    callback: DiffUtil.ItemCallback<T>,
    private val listener: ItemClickListener? = null
) :
    ListAdapter<T, BaseViewHolder>(callback) {

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is StockByFluctuation ->
                Const.LAYOUT_STOCK_FLUCTUATION_SHORT
            is StockByTransaction ->
                Const.LAYOUT_STOCK_TRANSACTION_SHORT
            is StockByMarketCap ->
                Const.LAYOUT_STOCK_MARKET_CAP_SHORT
            is StockByUpperLowerLimit ->
                Const.LAYOUT_STOCK_UPPER_LOWER_LIMIT_SHORT
            is StockByForeigner ->
                Const.LAYOUT_STOCK_FOREIGNER_SHORT
            is StockByTurnover ->
                Const.LAYOUT_STOCK_TURNOVER_SHORT
            is StockByBlockDeal ->
                Const.LAYOUT_STOCK_BLOCK_DEAL_SHORT
            is Grain ->
                Const.LAYOUT_GRAIN_SHORT
            is CrudeOil ->
                Const.LAYOUT_OIL_SHORT
            is BDIIndex ->
                Const.LAYOUT_BALTIC_INDICES_SHORT
            is StockBaseInfo ->
                Const.LAYOUT_STOCK_BASIC_INFO
            is StockFinancialStatement ->
                Const.LAYOUT_STOCK_FINANCIAL_STATEMENT
            is MonthlyTrading ->
                Const.LAYOUT_MONTHLY_TRADING
            is List<*> ->
                Const.LAYOUT_STOCK_SINGLE_LINE_CHART
            else -> {
                throw IllegalArgumentException("item type should match one of listed")
            }
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolderFactory.createByViewType(parent, viewType, listener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items[position].let {
            holder.bind(it)
        }
    }
}