package com.cariad.test.domain.usecases

import com.cariad.test.data.model.POIRequestHeaders
import com.cariad.test.domain.UseCase
import com.cariad.test.data.model.POIData
import com.cariad.test.data.repository.POIRepository

class GetPOIDataUseCase(
    private val POIRepository: POIRepository
) : UseCase<POIRequestHeaders, POIData> {

    override suspend fun execute(input: POIRequestHeaders): POIData =
        POIRepository.getAllPOI(input)
}