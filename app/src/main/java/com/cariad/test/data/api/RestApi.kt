package com.kumar.test.data.api

import com.kumar.test.data.model.POIData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


interface RestApi {


    @GET("v3/poi")
    suspend fun getPointOfInterest(
        @Header("latitude") latitude: Float,
        @Header("longitude") longitude: Float,
        @Header("distance") distance: Int,
        @Query("key") key: String = "1e2cb9c6-a0e9-4a68-bc09-f3c97a6bd8e4",
    ): Response<POIData>
}