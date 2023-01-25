package com.example.translatorapp.core.domain.util

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

actual open class CommonFlow<T> actual constructor(
    private val flow: Flow<T>
) : Flow<T> by flow {

    fun subscribe(
        coroutinesScope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        onCollect: (T) -> Unit
    ): DisposableHandle {
        val job = coroutinesScope.launch {
            flow.collect(onCollect)
        }
        return DisposableHandle { job.cancel() }
    }

    fun subscribe(
        onCollect: (T) -> Unit
    ): DisposableHandle {
        return subscribe(
            coroutinesScope = GlobalScope,
            dispatcher = Dispatchers.Main,
            onCollect = onCollect
        )
    }
}