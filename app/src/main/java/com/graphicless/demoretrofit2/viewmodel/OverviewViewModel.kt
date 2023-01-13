package com.graphicless.demoretrofit2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.graphicless.demoretrofit2.MarsApi
import com.graphicless.demoretrofit2.model.MarsPhoto
import kotlinx.coroutines.launch


class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<MarsPhoto>>()

    val status: LiveData<String> = _status
    val photos: LiveData<List<MarsPhoto>> = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = "Success: ${_photos.value!!.size} Mars photos retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}