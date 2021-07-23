package com.natife.example.multithreading_and_async.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {
    private val random = Random(System.nanoTime())
    private val mutableData = MutableLiveData<Int>()
    val data: LiveData<Int> = mutableData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                mutableData.postValue(random.nextInt(0, 1000))
                delay(random.nextInt(0, 2000).toLong())
            }
        }
    }
}