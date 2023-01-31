package com.example.translatorapp.di

import com.example.translatorapp.testing.FakeHistoryDataSource
import com.example.translatorapp.testing.FakeTranslateClient
import com.example.translatorapp.testing.FakeVoiceToTextParser
import com.example.translatorapp.translate.domain.translate.Translate

class TestAppModule : AppModule {
    override val historyDataSource = FakeHistoryDataSource()
    override val client = FakeTranslateClient()
    override val translateUseCase: Translate = Translate(client, historyDataSource)
    override val voiceParser = FakeVoiceToTextParser()
}