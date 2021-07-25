package com.natife.example.multithreading_and_async.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {
    private val random = Random(System.nanoTime())
    val data: StateFlow<Int> by lazy {
        val dataFlow = MutableStateFlow(0)
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                dataFlow.emit(random.nextInt(0, 1000))
                delay(random.nextInt(0, 2000).toLong())
            }
        }
        dataFlow
    }
}