package com.projectseoul.stockmarkettest.network

import com.projectseoul.stockmarkettest.entities.Stock
import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.utils.Const
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by KING JINHO on 9/14/2021
 */
interface StockMarketService {

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun scrapeCompanies(
        @Field(Const.CRAWLING_KEY_BLD) value1: String,
        @Field(Const.CRAWLING_KEY_MKTID) value2: String
    ): Response<Crawling<Stock>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getSectors(
        @Field(Const.CRAWLING_KEY_BLD) value1: String,
        @Field(Const.CRAWLING_KEY_MKTID) value2: String,
        @Field(Const.CRAWLING_KEY_TRDDD) value3: String,
        @Field(Const.CRAWLING_KEY_MONEY) value4: Int = 1
    ): Response<SectorCrawling>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getTop50ByFluctuation(
        @Field(Const.CRAWLING_KEY_ITMTPCD2) value1: Int,
        @Field(Const.CRAWLING_KEY_STRT_DD) value2: String,
        @Field(Const.CRAWLING_KEY_END_DD) value3: String,
        @Field(Const.CRAWLING_KEY_ITMTPCD1) value4: String = "Y",
        @Field(Const.CRAWLING_KEY_BLD) value5: String = Const.CRAWLING_VALUE_TOP_50_BY_FLUCTUATION,
        @Field(Const.CRAWLING_KEY_MKTID) value6: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_STK_PRC_TP_CD) value7: String = "Y",
        @Field(Const.CRAWLING_KEY_SHARE) value8: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value9: Int = 1,
    ): Response<Crawling<StockByFluctuation>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getTop50ByTransaction(
        @Field(Const.CRAWLING_KEY_ITMTPCD2) value1: Int,
        @Field(Const.CRAWLING_KEY_STRT_DD) value2: String,
        @Field(Const.CRAWLING_KEY_END_DD) value3: String,
        @Field(Const.CRAWLING_KEY_BLD) value4: String = Const.CRAWLING_VALUE_TOP_50_BY_TRANSACTION,
        @Field(Const.CRAWLING_KEY_MKTID) value5: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_ITMTPCD3) value6: Int = 1,
        @Field(Const.CRAWLING_KEY_STK_PRC_TP_CD) value7: String = "Y",
        @Field(Const.CRAWLING_KEY_SHARE) value8: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value9: Int = 1,
        @Field(Const.CRAWLING_KEY_ITMTPCD1) value10: String = "Y"
    ): Response<Crawling<StockByTransaction>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getTop50ByMarketCap(
        @Field(Const.CRAWLING_KEY_TRDDD) value1: String,
        @Field(Const.CRAWLING_KEY_ITMTPCD) value2: Int = 1,
        @Field(Const.CRAWLING_KEY_BLD) value3: String = Const.CRAWLING_VALUE_TOP_50_BY_MARKET_CAP,
        @Field(Const.CRAWLING_KEY_MKTID) value4: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_SHARE) value5: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value6: Int = 1
    ): Response<Crawling<StockByMarketCap>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getByUpperLowerLimit(
        @Field(Const.CRAWLING_KEY_FLUC_TP_CD) value1: Int,
        @Field(Const.CRAWLING_KEY_TRDDD) value2: String,
        @Field(Const.CRAWLING_KEY_BLD) value3: String = Const.CRAWLING_VALUE_TOP_DOWN_BY_30_PERCENT,
        @Field(Const.CRAWLING_KEY_MKTID) value4: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_SHARE) value5: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value6: Int = 1
    ): Response<Crawling<StockByUpperLowerLimit>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getTop50ByTurnover(
        @Field(Const.CRAWLING_KEY_TRDDD) value2: String,
        @Field(Const.CRAWLING_KEY_BLD) value3: String = Const.CRAWLING_VALUE_TOP_50_BY_TURNOVER,
        @Field(Const.CRAWLING_KEY_MKTID) value4: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_SHARE) value5: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value6: Int = 1
    ): Response<Crawling<StockByTurnover>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getTop50ByForeigner(
        @Field(Const.CRAWLING_KEY_ITMTPCD) value1: Int,
        @Field(Const.CRAWLING_KEY_TRDDD) value2: String,
        @Field(Const.CRAWLING_KEY_BLD) value3: String = Const.CRAWLING_VALUE_TOP_50_BY_FOREIGNER,
        @Field(Const.CRAWLING_KEY_MKTID) value4: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_SHARE) value5: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value6: Int = 1
    ): Response<Crawling<StockByForeigner>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getBlockTrade(
        @Field(Const.CRAWLING_KEY_BLD) value1: String = Const.CRAWLING_VALUE_BLOCK_TRADE,
        @Field(Const.CRAWLING_KEY_MKTID) value2: String = Const.CRAWLING_VALUE_ALL,
        @Field(Const.CRAWLING_KEY_SHARE) value3: Int = 1
    ): Response<CrawlingOutput<StockByBlockDeal>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getStockBaseInfo(
        @Field(Const.CRAWLING_KEY_ISU_CD) value1: String,
        @Field(Const.CRAWLING_KEY_BLD) value2: String = Const.CRAWLING_STOCK_BASE_INFO
    ): Response<StockBaseInfo>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getQuotationHistory(
        @Field(Const.CRAWLING_KEY_ISU_CD) value1: String,
        @Field(Const.CRAWLING_KEY_STRT_DD) value2: String,
        @Field(Const.CRAWLING_KEY_END_DD) value3: String,
        @Field(Const.CRAWLING_KEY_BLD) value4: String = Const.CRAWLING_STOCK_QUOTATION_HISTORY,
        @Field(Const.CRAWLING_KEY_SHARE) value5: Int = 1,
        @Field(Const.CRAWLING_KEY_MONEY) value6: Int = 1,
    ): Response<CrawlingOutput<StockQuotation>>

    @POST(Const.PATH_STOCK_MARKET)
    @FormUrlEncoded
    suspend fun getFinancialStatement(
        @Field(Const.CRAWLING_KEY_ISU_CD) value2: String,
        @Field(Const.CRAWLING_KEY_BLD) value1: String = Const.CRAWLING_STOCK_FINANCIAL_STATEMENT
    ): Response<StockFinancialStatement>

}