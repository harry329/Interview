package com.example.interview.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interview.model.Dog
import com.example.interview.repo.DogRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.immutableListOf

class Screen2VM(private val dogRepo: DogRepo) : ViewModel() {

    private var _dogInfo = MutableStateFlow(listOf<Dog>())
    val dogState = _dogInfo.asStateFlow()
    var apiJob: Job? = null

    fun fetchDogInfo() {
        apiJob = viewModelScope.launch (Dispatchers.IO) {
            while (apiJob?.isActive == true) {
                // Make API call here
                dogRepo.getDogInfo().collect {
                    Log.d("VM", it.message)
                    val listOfDogs = immutableListOf(it)
                    _dogInfo.update { listOfDogs }
                }
                delay(5000)
            }

        }
    }

    fun stopFetchingDogInfo() {
        apiJob?.cancel()
        apiJob = null
    }

}