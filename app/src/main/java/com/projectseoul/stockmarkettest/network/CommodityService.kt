package com.projectseoul.stockmarkettest.network

import com.projectseoul.stockmarkettest.models.*
import com.projectseoul.stockmarkettest.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by KING JINHO on 9/16/2021
 */
interface CommodityService {

    @GET(Const.PATH_CORN_WHEAT_SOYBEAN)
    suspend fun getGrain(
        @Path(Const.PATH_TYPE) type: String,
        @Path(Const.PATH_SDATE) startingDate: String, @Path(Const.PATH_EDATE) endDate: String
    ) : Response<List<CornSoyWheatJson>>

    @GET(Const.PATH_SUGAR_COTTON)
    suspend fun getSugarCotton(
        @Path(Const.PATH_TYPE) type: String,
        @Path(Const.PATH_SDATE) startingDate: String,
        @Path(Const.PATH_EDATE) endDate: String
    ): Response<List<SugarCottonJson>>

    @GET(Const.PATH_COFFEE)
    suspend fun getCoffee(
        @Path(Const.PATH_SDATE) startingDate: String,
        @Path(Const.PATH_EDATE) endDate: String
    ): Response<List<CoffeeJson>>

    @GET(Const.PATH_BALTIC_DRY_INDEX)
    suspend fun getBDIs(
        @Path(Const.PATH_SDATE) startingDate: String,
        @Path(Const.PATH_EDATE) endDate: String
    ): Response<List<BDIIndex>>

    @GET(Const.PATH_CRUDE_OIL)
    suspend fun getCrudeOil(
        @Path(Const.PATH_SDATE) startingDate: String,
        @Path(Const.PATH_EDATE) endDate: String
    ): Response<List<CrudeOil>>

}