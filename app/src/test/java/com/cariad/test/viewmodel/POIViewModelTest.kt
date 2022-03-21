package com.cariad.test.viewmodel

import com.cariad.test.domain.POIDomainModel
import com.cariad.test.domain.usecases.GetPOIDataUseCase
import com.cariad.test.list
import com.cariad.test.presentation.viewmodel.POIViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class POIViewModelTest {


    @Mock
    private lateinit var getPOIDataUseCase: GetPOIDataUseCase

    private lateinit var viewModel: POIViewModel

    private val correctMarkerName = "Hello"
    private val incorrectMarkerName = "NONAME"

    @Before
    fun setup() {
        viewModel = POIViewModel(getPOIDataUseCase)
    }

    @Test
    fun test_getPOIDomainModelFromSelectedMarker_with_correct_name_expect_notNull() {
        viewModel.poiList.addAll(list)
        val poiDomainModel: POIDomainModel? =
            viewModel.getPOIDomainModelFromSelectedMarker(correctMarkerName)
        assertNotNull(poiDomainModel)
    }

    @Test
    fun test_getPOIDomainModelFromSelectedMarker_with_incorrect_name_expect_null() {
        viewModel.poiList.addAll(list)
        val poiDomainModel: POIDomainModel? =
            viewModel.getPOIDomainModelFromSelectedMarker(incorrectMarkerName)

        assertNull(poiDomainModel)
    }

}