package com.cariad.test.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cariad.test.domain.usecases.GetPOIDataUseCase
import com.cariad.test.presentation.util.Event
import com.kumar.test.data.model.POIData
import com.kumar.test.data.model.POIRequestHeaders
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


    val fetchDataJob = fetchPOIListJob()

    fun cancelDataFetch() {
        fetchDataJob.cancel()
    }

    private fun fetchPOIListJob(): Job =
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                fetchPOIList()
                delay(TimeUnit.SECONDS.toMillis(30))
            }
        }


    private suspend fun fetchPOIList() {
        val list = getPOIDataUseCase.execute(POIRequestHeaders())
        _poiDisplayList.postValue(Event(list))
    }

}