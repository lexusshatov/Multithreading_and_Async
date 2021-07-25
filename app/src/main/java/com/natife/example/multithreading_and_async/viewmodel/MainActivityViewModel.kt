package com.natife.example.multithreading_and_async.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

class MainActivityViewModel: ViewModel() {
    private val random = Random(System.nanoTime())
    val data: Observable<Int> = Observable.create {
        while (true) {
            it.onNext(random.nextInt(0, 1000))
            Thread.sleep(random.nextInt(0, 2000).toLong())
        }
    }
}