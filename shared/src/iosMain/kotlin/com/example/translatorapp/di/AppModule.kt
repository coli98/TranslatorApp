package com.example.translatorapp.di

import com.example.translatorapp.database.TranslateDataBase
import com.example.translatorapp.translate.data.history.SqlDelightHistoryDataSource
import com.example.translatorapp.translate.data.local.DatabaseDriverFactory
import com.example.translatorapp.translate.data.remote.HttpClientFactory
import com.example.translatorapp.translate.data.translate.KtorTranslateClient
import com.example.translatorapp.translate.domain.history.HistoryDataSource
import com.example.translatorapp.translate.domain.translate.Translate
import com.example.translatorapp.translate.domain.translate.TranslateClient
import com.example.translatorapp.voice_to_text.domain.VoiceToTextParser

interface AppModule{
    val historyDataSource: HistoryDataSource
    val client: TranslateClient
    val translateUseCase : Translate
    val voiceParser: VoiceToTextParser
}

class AppModuleImpl(
    parser: VoiceToTextParser
) : AppModule {

    override val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDataBase(
                DatabaseDriverFactory().create()
            )
        )
    }

    override val client: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    override val translateUseCase: Translate by lazy {
        Translate(client, historyDataSource)
    }

    override val voiceParser = parser
}