package com.kumar.test.data.repository

import com.kumar.test.data.api.RestApi
import com.kumar.test.data.model.POIData
import com.kumar.test.data.model.POIRequestHeaders
import retrofit2.Response
import java.io.IOException

class POIRepository(private val restApi: RestApi) {

    suspend fun getAllPOI(poiRequestHeaders: POIRequestHeaders): POIData = processResponse(
        restApi.getPointOfInterest(
            poiRequestHeaders.latitude,
            poiRequestHeaders.longitude,
            poiRequestHeaders.distance
        )
    )

    private fun processResponse(response: Response<POIData>): POIData = when {
        response.isSuccessful -> {
            response.body() ?: throw IOException()
        }
        else ->
            throw IOException()
    }

}
