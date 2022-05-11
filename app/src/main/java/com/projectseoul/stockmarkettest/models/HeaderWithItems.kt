package com.projectseoul.stockmarkettest.models

import androidx.annotation.StringRes
import com.projectseoul.stockmarkettest.R

/**
 * Created by KING JINHO on 9/15/2021
 */
sealed class HeaderWithItems(
    @StringRes open var titleRes: Int,
    val from: ECriteria, val enableDelay: Boolean = true
)

data class HeaderWithFluctuation(
    val items: List<StockByFluctuation>
) : HeaderWithItems(R.string.main_up_down_top_50, ECriteria.FLUCTUATION)

data class HeaderWithTransaction(
    val items: List<StockByTransaction>
) : HeaderWithItems(R.string.main_top_50_by_transaction, ECriteria.TRANSACTION)

data class HeaderWithMarketCap(
    val items: List<StockByMarketCap>
) : HeaderWithItems(R.string.main_top_50_by_market_cap, ECriteria.MARKET_CAP)

data class HeaderWithUpperLowerLimit(
    val items: List<StockByUpperLowerLimit>
) : HeaderWithItems(R.string.main_upper_lower_limit, ECriteria.UPPER_LOWER_LIMIT)

data class HeaderWithTurnover(
    val items: List<StockByTurnover>
) : HeaderWithItems(R.string.main_top_50_by_turnover, ECriteria.TURNOVER)

data class HeaderWithForeigner(
    val items: List<StockByForeigner>
) : HeaderWithItems(R.string.main_top_50_by_foreigner, ECriteria.FOREIGNER)

data class HeaderWithBlockDeal(
    val items: List<StockByBlockDeal>
) : HeaderWithItems(R.string.main_block_deal, ECriteria.BLOCK_DEAL)

data class HeaderWithGrains(
    val items: List<Grain>
) : HeaderWithItems(R.string.main_grain_price, ECriteria.GRAIN, false)

data class HeaderWithOil(
    val items: List<CrudeOil>
) : HeaderWithItems(R.string.main_oil_price, ECriteria.OIL, false)

data class HeaderWithBalticIndices(
    val items: List<BDIIndex>
) : HeaderWithItems(R.string.main_bdi_index, ECriteria.BALTIC_INDEX, false)

data class HeaderWithBasicInfo(
    val items: List<StockBaseInfo>
) : HeaderWithItems(R.string.stock_detail_basic_info, ECriteria.BASIC_INFO, false)

data class HeaderWithStatement(
    val items: List<StockFinancialStatement>
) : HeaderWithItems(R.string.stock_detail_financial_statement, ECriteria.FINANCIAL_STATEMENT, false)

data class HeaderWithSingleLineChart(
    override var titleRes: Int,
    val items: List<List<SingleLineChart>>
) : HeaderWithItems(titleRes, ECriteria.LINE_CHART, false)

data class HeaderWithMonthlyTrading(
    val items: List<MonthlyTrading>
) : HeaderWithItems(R.string.main_monthly_trading, ECriteria.MONTHLY_TRADING, false)