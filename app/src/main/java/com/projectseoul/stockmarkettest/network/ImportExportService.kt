package com.projectseoul.stockmarkettest.network

import com.projectseoul.stockmarkettest.models.MonthlyTrading
import com.projectseoul.stockmarkettest.models.MonthlyTradingJson
import com.projectseoul.stockmarkettest.utils.Const
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by KING JINHO on 10/5/2021
 */
interface ImportExportService {

    @POST(Const.PATH_IMPORT_EXPORT)
    @FormUrlEncoded
    suspend fun getMonthlyTradingData(
        @Field(Const.CRAWLING_KEY_PRIOD_FR) from: String,
        @Field(Const.CRAWLING_KEY_PRIOD_TO) to: String,
        @Field(Const.CRAWLING_KEY_IS_ALL) isAll:String = Const.CRAWLING_IS_ALL,
        @Field(Const.CRAWLING_KEY_PAGE_INDEX) index: String = Const.CRAWLING_PAGE_INDEX,
        @Field(Const.CRAWLING_KEY_PAGE_UNIT) count: String = Const.CRAWLING_PAGE_UNIT,
        @Field(Const.CRAWLING_KEY_PRIOD_KIND) type: String = Const.CRAWLING_PRIOD_KIND,
        @Field(Const.CRAWLING_KEY_MENU_ID) id: String = Const.CRAWLING_MENU_ID
    ) : Response<MonthlyTradingJson>

}