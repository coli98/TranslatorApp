package com.example.translatorapp.di

import com.example.translatorapp.database.TranslateDataBase
import com.example.translatorapp.translate.data.history.SqlDelightHistoryDataSource
import com.example.translatorapp.translate.data.local.DatabaseDriverFactory
import com.example.translatorapp.translate.data.remote.HttpClientFactory
import com.example.translatorapp.translate.data.translate.KtorTranslateClient
import com.example.translatorapp.translate.domain.history.HistoryDataSource
import com.example.translatorapp.translate.domain.translate.Translate
import com.example.translatorapp.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDataBase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(translateClient, historyDataSource)
    }
}