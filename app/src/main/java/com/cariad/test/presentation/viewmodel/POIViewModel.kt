package com.cariad.test.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.cariad.test.domain.usecases.GetPOIDataUseCase

class POIViewModel(
    private val getPOIDataUseCase: GetPOIDataUseCase
) : ViewModel() {

}