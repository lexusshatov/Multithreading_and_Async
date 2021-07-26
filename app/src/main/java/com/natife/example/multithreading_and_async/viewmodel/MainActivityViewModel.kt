package com.natife.example.multithreading_and_async.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
    private val random = Random(System.nanoTime())
    val data = generateSequence {
        runBlocking {
            delay(1000)
        }
        random.nextInt(0, 1000)
    }
        .asFlow()
        .map { it.toString() }
}