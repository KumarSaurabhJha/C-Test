package com.cariad.test.data.api

import com.cariad.test.data.model.POIData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface RestApi {


    @GET("v3/poi")
    suspend fun getPointOfInterest(
        @Header("latitude") latitude: Double,
        @Header("longitude") longitude: Double,
        @Header("distance") distance: Int,
        @Query("key") key: String = "1e2cb9c6-a0e9-4a68-bc09-f3c97a6bd8e4",
    ): Response<POIData>
}