package com.natife.example.multithreading_and_async.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
    private val random = Random(System.nanoTime())
    val data = flow {
        while (true) {
            delay(1000)
            emit(random.nextInt(0, 1000))
        }
    }
        .map { it.toString() }
}