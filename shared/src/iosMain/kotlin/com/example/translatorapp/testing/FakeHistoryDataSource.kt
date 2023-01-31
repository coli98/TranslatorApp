package com.example.translatorapp.testing

import com.example.translatorapp.core.domain.util.CommonFlow
import com.example.translatorapp.core.domain.util.toCommonFlow
import com.example.translatorapp.translate.domain.history.HistoryDataSource
import com.example.translatorapp.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.MutableStateFlow

class FakeHistoryDataSource : HistoryDataSource {

    private val _data = MutableStateFlow<List<HistoryItem>>(emptyList())

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return _data.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        _data.value += item
    }
}