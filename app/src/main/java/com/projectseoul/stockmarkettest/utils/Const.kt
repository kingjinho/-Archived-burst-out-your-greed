package com.projectseoul.stockmarkettest.utils

import com.projectseoul.stockmarkettest.R
import com.squareup.moshi.Json

/**
 * Created by KING JINHO on 9/14/2021
 */
object Const {
    const val DB_NAME = "stock.db"

    const val TABLE_STOCK = "STOCK"
    const val TABLE_LAST_UPDATE = "LAST_UPDATE"
    const val TABLE_CRYPTO_CURRENCY = "CRYPTO_CURRENCY"
    const val TIME_ZONE_SEOUL = "Asia/Seoul"

    const val UPBIT_WARNING = "CAUTION"
    const val UPBIT_NONE = "NONE"

    const val NOT_APPLICABLE = "N/A"

    const val DATE_FORMAT = "yyyyMMdd"

    const val KOSPI = "KOSPI"
    const val KOSDAQ = "KOSDAQ"

    //network request path
    const val PATH_STOCK_MARKET = "comm/bldAttendant/getJsonData.cmd"
    const val PATH_UPBIT_GET_ALL_TICKERS = "market/all"

    const val PATH_IMPORT_EXPORT = "ets/hmpg/retrieveImexOvrlLst.do"


    const val PATH_CORN_WHEAT_SOYBEAN = "chart/main_chart/index/kind/{TYPE}/sdate/{SDATE}/edate/{EDATE}"
    const val PATH_BALTIC_DRY_INDEX = "chart/bdi/index/sdate/{SDATE}/edate/{EDATE}"
    const val PATH_SUGAR_COTTON = "chart/{TYPE}/index/sdate/{SDATE}/edate/{EDATE}"

    const val PATH_COFFEE = "chart/coffee/index/sdate/{SDATE}/edate/{EDATE}"
    const val PATH_CRUDE_OIL = "chart/oil/index/sdate/{SDATE}/edate/{EDATE}"

    const val PATH_TYPE = "TYPE"
    const val PATH_SDATE = "SDATE"
    const val PATH_EDATE = "EDATE"
    const val PATH_WHEAT = "W"
    const val PATH_SOYBEAN = "S"
    const val PATH_CORN = "C"
    const val PATH_SUGAR = "sugar"
    const val PATH_COTTON = "cotton"


    //network response
    const val JSON_ISU_CD = "ISU_CD"
    const val JSON_ISU_SRT_CD = "ISU_SRT_CD"
    const val JSON_ISU_NM = "ISU_NM"
    const val JSON_ISU_ABBRV = "ISU_ABBRV"
    const val JSON_ISU_ENG_NM = "ISU_ENG_NM"
    const val JSON_LIST_DD = "LIST_DD"
    const val JSON_MKT_TP_NM = "MKT_TP_NM"
    const val JSON_KIND_STKCERT_TP_NM = "KIND_STKCERT_TP_NM"
    const val JSON_LIST_SHRS = "LIST_SHRS"
    const val JSON_IDX_IND_NM = "IDX_IND_NM"
    const val JSON_OUT_BLOCK_1 = "OutBlock_1"
    const val JSON_BLOCK_1 = "block1"
    const val JSON_MKT_NM = "MKT_NM"
    const val JSON_BAS_PRC = "BAS_PRC"
    const val JSON_CLSPRC = "CLSPRC"
    const val JSON_CMPPREVDD_PRC = "CMPPREVDD_PRC"
    const val JSON_FLUC_RT = "FLUC_RT"
    const val JSON_ACC_TRDVOL = "ACC_TRDVOL"
    const val JSON_DYAVG_TRDVOL = "DYAVG_TRDVOL"
    const val JSON_ACC_TRDVAL = "ACC_TRDVAL"
    const val JSON_DYAVG_TRDVAL = "DYAVG_TRDVAL"
    const val JSON_MKTCAP = "MKTCAP"
    const val JSON_MKTCAP_WEIGHT = "MKTCAP_WT"
    const val JSON_TDD_CLSPRC = "TDD_CLSPRC"
    const val JSON_TDD_OPNPRC = "TDD_OPNPRC"
    const val JSON_TDD_HGPRC = "TDD_HGPRC"
    const val JSON_TDD_LWPRC = "TDD_LWPRC"
    const val JSON_TURNOVER_RT = "TURNOVER_RT"
    const val JSON_HD_QTY = "HD_QTY"
    const val JSON_FORN_ORD_LMT_QTY = "FORN_ORD_LMT_QTY"
    const val JSON_HD_RTO = "HD_RTO"
    const val JSON_ITM_RTO = "ITM_RTO"
    const val JSON_CMP_PRC = "CMP_PRC"
    const val JSON_IDX_NM = "IDX_NM"
    const val JSON_BLK_TRDVOL = "BLK_TRDVOL"
    const val JSON_BLK_TRD_RTO = "BLK_TRD_RTO"
    const val JSON_OUTPUT = "output"
    const val JSON_CMPPRVDD_PRC = "CMPPRVDD_PRC"

    const val JSON_TRD_DD = "TRD_DD"
    const val JSON_ASST_TOTAMT = "ASST_TOTAMT"
    const val JSON_DEBT_TOTAMT = "DEBT_TOTAMT"
    const val JSON_CAP = "CAP"
    const val JSON_CAP_GRNDTOT = "CAP_GRNDTOT"
    const val JSON_SALES = "SALES"
    const val JSON_OPERPROFT_AMT = "OPERPROFT_AMT"
    const val JSON_NETINCM = "NETINCM"

    const val JSON_UPBIT_TICKER = "market"
    const val JSON_UPBIT_TICKER_NAME = "korean_name"
    const val JSON_UPBIT_TICKER_NAME_ENG = "english_name"
    const val JSON_UPBIT_MARKET_WARNING = "market_warning"

    const val JSON_WTI = "WTI"
    const val JSON_BRENT = "Brent"
    const val JSON_DUBAI = "Dubai"
    const val JSON_SETTLEMENT = "settlement"
    const val JSON_SETTLE = "settle"

    const val JSON_PRSNT_PRC = "PRSNT_PRC"
    const val JSON_WK52_HGST_PRC = "WK52_HGST_PRC"
    const val JSON_WK52_LWST_PRC = "WK52_LWST_PRC"
    const val JSON_FORN_RTO = "FORN_RTO"
    const val JSON_PERIOD_TITLE = "priodTitle"
    const val JSON_EXPORT_COUNT = "expCnt"
    const val JSON_EXPORT_USD_AMOUNT = "expUsdAmt"
    const val JSON_IMPORT_COUNT = "impCnt"
    const val JSON_IMPORT_USD_AMOUNT =  "impUsdAmt"
    const val JSON_TRADE_SURPLUS = "cmtrBlncAmt"

    //network requests
    const val CRAWLING_KEY_BLD = "bld"
    const val CRAWLING_KEY_MKTID = "mktId"
    const val CRAWLING_KEY_SHARE = "share"
    const val CRAWLING_KEY_MONEY = "money"
    const val CRAWLING_KEY_ISU_CD = "isuCd"


    const val CRAWLING_KEY_TRDDD = "trdDd"

    const val CRAWLING_KEY_ITMTPCD = "itmTpCd"
    const val CRAWLING_KEY_ITMTPCD1 = "itmTpCd1"
    const val CRAWLING_KEY_ITMTPCD2 = "itmTpCd2"
    const val CRAWLING_KEY_ITMTPCD3 = "itmTpCd3"
    const val CRAWLING_KEY_STRT_DD = "strtDd"
    const val CRAWLING_KEY_END_DD = "endDd"
    const val CRAWLING_KEY_STK_PRC_TP_CD = "stkprcTpCd"
    const val CRAWLING_KEY_FLUC_TP_CD = "flucTpCd"
    const val CRAWLING_KEY_SEC_GROUP_ID = "secugrpId"

    const val CRAWLING_KEY_IS_ALL = "isAll"
    const val CRAWLING_KEY_PAGE_INDEX = "pageIndex"
    const val CRAWLING_KEY_PAGE_UNIT = "pageUnit"
    const val CRAWLING_KEY_PRIOD_KIND = "priodKind"
    const val CRAWLING_KEY_PRIOD_FR = "priodFr"
    const val CRAWLING_KEY_PRIOD_TO = "priodTo"
    const val CRAWLING_KEY_MENU_ID = "menuId"


    const val CRAWLING_COMPANY_VALUE1 = "dbms/MDC/STAT/standard/MDCSTAT01901"
    const val CRAWLING_VALUE_ALL = "ALL"

    const val CRAWLING_SECTOR_VALUE1 = "dbms/MDC/STAT/standard/MDCSTAT03901"
    const val CRAWLING_VALUE_KOSPI = "STK"
    const val CRAWLING_VALUE_KOSDAQ = "KSQ"

    const val CRAWLING_VALUE_SEC_GROUP_ID = "EF"

    const val CRAWLING_VALUE_TOP_50_BY_FLUCTUATION = "dbms/MDC/EASY/ranking/MDCEASY01501"
    const val CRAWLING_VALUE_TOP_50_BY_TRANSACTION = "dbms/MDC/EASY/ranking/MDCEASY01601"
    const val CRAWLING_VALUE_TOP_50_BY_MARKET_CAP = "dbms/MDC/EASY/ranking/MDCEASY01701"
    const val CRAWLING_VALUE_TOP_DOWN_BY_30_PERCENT = "dbms/MDC/EASY/ranking/MDCEASY01801"
    const val CRAWLING_VALUE_TOP_50_BY_TURNOVER = "dbms/MDC/EASY/ranking/MDCEASY02001"
    const val CRAWLING_VALUE_TOP_50_BY_FOREIGNER = "dbms/MDC/EASY/ranking/MDCEASY02101"
    const val CRAWLING_VALUE_TOP_50_ETF_BY_FLUCTUATION = "dbms/MDC/EASY/ranking/MDCEASY02201"
    const val CRAWLING_VALUE_TOP_50_ETF_BY_TRANSACTION = "dbms/MDC/EASY/ranking/MDCEASY02301"
    const val CRAWLING_VALUE_BLOCK_TRADE = "dbms/MDC/STAT/standard/MDCSTAT02501"
    const val CRAWLING_STOCK_BASE_INFO = "dbms/MDC/STAT/standard/MDCSTAT02101"
    const val CRAWLING_STOCK_QUOTATION_HISTORY = "dbms/MDC/STAT/standard/MDCSTAT01701"
    const val CRAWLING_STOCK_FINANCIAL_STATEMENT = "dbms/MDC/STAT/standard/MDCSTAT02104"

    const val CRAWLING_IS_ALL = "NO"
    const val CRAWLING_PAGE_INDEX = "1"
    const val CRAWLING_PAGE_UNIT = "20"
    const val CRAWLING_PRIOD_KIND = "MON"
    const val CRAWLING_MENU_ID = "ETS_MNU_00000102"

    const val UPBIT_GET_ALL_TICKERS = "isDetails"

    //table columns
    const val COLUMN_KD = "KD"
    const val COLUMN_STOCK_CODE = "STOCK_CODE"
    const val COLUMN_COMPANY_NAME = "COMPANY_NAME"
    const val COLUMN_COMPANY_NAME_ENG = "COMPANY_NAME_ENG"
    const val COLUMN_SECTOR = "SECTOR"
    const val COLUMN_DATE_LISTED = "DATE_LISTED"
    const val COLUMN_STOCK_MARKET = "STOCK_MARKET"
    const val COLUMN_COMMON_PREFERRED = "COMMON_PREFERRED"
    const val COLUMN_TOTAL_SHARES = "TOTAL_SHARES"
    const val COLUMN_TABLE_NAME = "TABLE_NAME"
    const val COLUMN_LAST_UPDATE = "LAST_UPDATE"

    const val COLUMN_TICKER = "TICKER"
    const val COLUMN_NAME = "NAME"
    const val COLUMN_NAME_ENG = "NAME_ENG"
    const val COLUMN_HAS_WARNING = "HAS_WARNING"


    const val LAYOUT_STOCK_FLUCTUATION = R.layout.item_stock_fluctuation
    const val LAYOUT_STOCK_FLUCTUATION_SHORT = R.layout.item_stock_fluctuation_short
    const val LAYOUT_STOCK_TRANSACTION_SHORT = R.layout.item_stock_transaction_short
    const val LAYOUT_STOCK_TRANSACTION = R.layout.item_stock_transaction
    const val LAYOUT_STOCK_MARKET_CAP = R.layout.item_stock_market_cap
    const val LAYOUT_STOCK_MARKET_CAP_SHORT = R.layout.item_stock_market_cap_short
    const val LAYOUT_STOCK_UPPER_LOWER_LIMIT = R.layout.item_stock_upper_lower
    const val LAYOUT_STOCK_UPPER_LOWER_LIMIT_SHORT = R.layout.item_stock_upper_lower_short
    const val LAYOUT_STOCK_FOREIGNER = R.layout.item_stock_foreigner
    const val LAYOUT_STOCK_FOREIGNER_SHORT = R.layout.item_stock_foreigner_short
    const val LAYOUT_STOCK_TURNOVER = R.layout.item_stock_turnover
    const val LAYOUT_STOCK_TURNOVER_SHORT = R.layout.item_stock_turnover_short
    const val LAYOUT_STOCK_BLOCK_DEAL = R.layout.item_stock_block_deal
    const val LAYOUT_STOCK_BLOCK_DEAL_SHORT = R.layout.item_stock_block_deal_short
    const val LAYOUT_GRAIN = R.layout.item_grain
    const val LAYOUT_GRAIN_SHORT = R.layout.item_grain_short
    const val LAYOUT_OIL = R.layout.item_oil
    const val LAYOUT_OIL_SHORT = R.layout.item_oil_short
    const val LAYOUT_BALTIC_INDICES = R.layout.item_baltic_index
    const val LAYOUT_BALTIC_INDICES_SHORT = R.layout.item_baltic_index_short
    const val LAYOUT_STOCK_BASIC_INFO = R.layout.item_stock_base_information
    const val LAYOUT_STOCK_FINANCIAL_STATEMENT = R.layout.item_financial_statement
    const val LAYOUT_STOCK_SINGLE_LINE_CHART = R.layout.item_stock_quotation
    const val LAYOUT_MONTHLY_TRADING = R.layout.item_monthly_trading
}