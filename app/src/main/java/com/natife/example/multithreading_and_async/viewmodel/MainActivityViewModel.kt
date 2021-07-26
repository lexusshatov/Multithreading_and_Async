package com.natife.example.multithreading_and_async.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {
    private val random = Random(System.nanoTime())
    val data: Observable<String> = Observable.interval(1, TimeUnit.SECONDS)
        .map { random.nextInt(0, 1000) }
        .map { it.toString() }
}