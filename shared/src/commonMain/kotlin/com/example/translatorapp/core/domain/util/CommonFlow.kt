package com.example.translatorapp.core.domain.util

import kotlinx.coroutines.flow.Flow

expect open class CommonFlow<T>(flow: Flow<T>) : Flow<T>

fun <T> Flow<T>.toCommonFlow() = CommonFlow(this)
