package com.projectseoul.stockmarkettest.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.projectseoul.stockmarkettest.databinding.*
import com.projectseoul.stockmarkettest.recyclerview.viewholders.*
import com.projectseoul.stockmarkettest.screens.main.ScreenMainMvc
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_BALTIC_INDICES_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_GRAIN_SHORT
import com.projectseoul.stockmarkettest.utils.Const.LAYOUT_MONTHLY_TRADING
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

/**
 * Created by KING JINHO on 9/18/2021
 */
class ItemViewHolderFactory {

    companion object {
        fun createByViewType(
            parent: ViewGroup,
            viewType: Int,
            listener: ScreenMainMvc.ItemClickListener?
        ): BaseViewHolder {
            return when (viewType) {
                LAYOUT_STOCK_FLUCTUATION_SHORT -> {
                    StockFluctuationShortVH(
                        ItemStockFluctuationShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_TRANSACTION_SHORT -> {
                    StockTransactionShortVH(
                        ItemStockTransactionShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_MARKET_CAP_SHORT -> {
                    StockMarketCapShortVH(
                        ItemStockMarketCapShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_UPPER_LOWER_LIMIT_SHORT -> {
                    StockUpperLowerShortVH(
                        ItemStockUpperLowerShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_FOREIGNER_SHORT -> {
                    StockForeignerShortVH(
                        ItemStockForeignerShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_TURNOVER_SHORT -> {
                    StockTurnoverShortVH(
                        ItemStockTurnoverShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_STOCK_BLOCK_DEAL_SHORT -> {
                    StockBlockDealShortVH(
                        ItemStockBlockDealShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        ), listener!!
                    )
                }
                LAYOUT_GRAIN_SHORT -> {
                    GrainShortVH(
                        ItemGrainShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_OIL_SHORT -> {
                    OilShortVH(
                        ItemOilShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_BALTIC_INDICES_SHORT -> {
                    BalticIndicesShortVH(
                        ItemBalticIndexShortBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_STOCK_BASIC_INFO -> {
                    StockBasicInfoVH(
                        ItemStockBaseInformationBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_STOCK_FINANCIAL_STATEMENT -> {
                    StockFinancialStatementVH(
                        ItemFinancialStatementBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_STOCK_SINGLE_LINE_CHART -> {
                    SingleLineChartVH(
                        ItemStockQuotationBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_MONTHLY_TRADING -> {
                    MonthlyTradingVH(
                        ItemMonthlyTradingBinding.inflate(
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