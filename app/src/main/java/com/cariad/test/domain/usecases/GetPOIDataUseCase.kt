package com.cariad.test.domain.usecases

import com.cariad.test.data.model.POIData
import com.cariad.test.data.model.POIRequestHeaders
import com.cariad.test.data.repository.POIRepository
import com.cariad.test.domain.UseCase

class GetPOIDataUseCase(
    private val POIRepository: POIRepository
) : UseCase<POIRequestHeaders, POIData> {

    override suspend fun execute(input: POIRequestHeaders): POIData =
        POIRepository.getAllPOI(input)
}