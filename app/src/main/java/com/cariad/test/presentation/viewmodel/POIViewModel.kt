package com.cariad.test.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cariad.test.data.model.POIRequestHeaders
import com.cariad.test.domain.usecases.GetPOIDataUseCase
import com.cariad.test.presentation.util.Event
import com.cariad.test.data.model.POIData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class POIViewModel(
    private val getPOIDataUseCase: GetPOIDataUseCase
) : ViewModel() {
    private val _poiDisplayList = MutableLiveData<Event<POIData>>()
    val poiDisplayList: LiveData<Event<POIData>> get() = _poiDisplayList

    val latitude: Double = 52.526
    val longitude: Double = 13.415
    private val distance: Int = 5

    private var fetchDataJob: Job? = null

    fun cancelDataFetch() {

        fetchDataJob?.let {
            if (it.isActive) {
                it.cancel()
            }
        }
    }

    fun init() {
        fetchDataJob = viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                fetchPOIList()
                delay(TimeUnit.SECONDS.toMillis(30))
            }
        }
    }


    private suspend fun fetchPOIList() {
        val list = getPOIDataUseCase.execute(
            POIRequestHeaders(
                latitude = latitude,
                longitude = longitude,
                distance = distance
            )
        )
        _poiDisplayList.postValue(Event(list))
    }

}