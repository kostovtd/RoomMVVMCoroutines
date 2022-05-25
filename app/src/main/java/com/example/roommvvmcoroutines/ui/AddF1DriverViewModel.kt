package com.example.roommvvmcoroutines.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roommvvmcoroutines.data.F1DriverRepository
import com.example.roommvvmcoroutines.data.Resource
import com.example.roommvvmcoroutines.data.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddF1DriverViewModel @Inject constructor(private val f1DriverRepository: F1DriverRepository) :
    ViewModel() {

    val isDriverAdded: MutableLiveData<Resource<Any>> by lazy {
        MutableLiveData<Resource<Any>>()
    }

    fun addF1Driver(
        firstName: String?,
        lastName: String?,
        team: String?,
        age: Int?,
        numberOfPodiums: Int?
    ) {
        viewModelScope.launch {
            isDriverAdded.value = f1DriverRepository.addNewF1Driver(firstName, lastName, team, age, numberOfPodiums)
        }
    }
}