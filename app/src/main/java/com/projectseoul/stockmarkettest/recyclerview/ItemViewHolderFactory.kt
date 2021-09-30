package com.projectseoul.stockmarkettest.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.projectseoul.stockmarkettest.databinding.*
import com.projectseoul.stockmarkettest.models.EFrom
import com.projectseoul.stockmarkettest.recyclerview.viewholders.*
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_BALTIC_INDICES_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_GRAIN_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_OIL_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_BASIC_INFO
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_BLOCK_DEAL_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_FINANCIAL_STATEMENT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_FLUCTUATION_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_FOREIGNER_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_MARKET_CAP_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_SINGLE_LINE_CHART
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_TRANSACTION_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_TURNOVER_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_STOCK_UPPER_LOWER_LIMIT_SHORT
import java.lang.IllegalArgumentException

/**
 * Created by KING JINHO on 9/18/2021
 */
class ItemViewHolderFactory {

    companion object {
        fun createByViewType(
            parent: ViewGroup,
            viewType: Int,
            listener: ItemClickListener?
        ): BaseViewHolder {
            return when (viewType) {
                LAYOUT_STOCK_FLUCTUATION_SHORT -> {
                    StockFluctuationShortViewHolder(
                        ItemStockFluctuationShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_TRANSACTION_SHORT -> {
                    StockTransactionShortViewHolder(
                        ItemStockTransactionShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_MARKET_CAP_SHORT -> {
                    StockMarketCapShortViewHolder(
                        ItemStockMarketCapShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_UPPER_LOWER_LIMIT_SHORT -> {
                    StockUpperLowerShortViewHolder(
                        ItemStockUpperLowerShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_FOREIGNER_SHORT -> {
                    StockForeignerShortViewHolder(
                        ItemStockForeignerShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_TURNOVER_SHORT -> {
                    StockTurnoverShortViewHolder(
                        ItemStockTurnoverShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_BLOCK_DEAL_SHORT -> {
                    StockBlockDealShortViewHolder(
                        ItemStockBlockDealShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_GRAIN_SHORT -> {
                    GrainShortViewHolder(
                        ItemGrainShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_OIL_SHORT -> {
                    OilShortViewHolder(
                        ItemOilShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_BALTIC_INDICES_SHORT -> {
                    BalticIndicesShortViewHolder(
                        ItemBalticIndexShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_STOCK_BASIC_INFO -> {
                    StockBasicInfoViewHolder(
                        ItemStockBaseInformationBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_STOCK_FINANCIAL_STATEMENT -> {
                    StockFinancialStatementViewHolder(
                        ItemFinancialStatementBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_STOCK_SINGLE_LINE_CHART -> {
                    SingleLineChartViewHolder(
                        ItemStockQuotationBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }

                else -> throw IllegalArgumentException("view type must match!")
            }
        }
    }
}