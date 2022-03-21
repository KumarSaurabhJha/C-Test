package com.cariad.test.domain.usecases

import com.cariad.test.data.model.POIData
import com.cariad.test.data.model.POIRequestHeaders
import com.cariad.test.data.repository.POIRepository
import com.cariad.test.domain.UseCase

open class GetPOIDataUseCase(
    private val poiRepository: POIRepository
) : UseCase<POIRequestHeaders, POIData> {

    override suspend fun execute(input: POIRequestHeaders): POIData =
        poiRepository.getAllPOI(input)
}