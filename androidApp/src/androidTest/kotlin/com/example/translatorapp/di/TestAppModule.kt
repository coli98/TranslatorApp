package com.example.translatorapp.di

import com.example.translatorapp.data.local.FakeHistoryDataSource
import com.example.translatorapp.data.remote.FakeTranslateClient
import com.example.translatorapp.translate.domain.history.HistoryDataSource
import com.example.translatorapp.translate.domain.translate.Translate
import com.example.translatorapp.translate.domain.translate.TranslateClient
import com.example.translatorapp.voice_to_text.data.FakeVoiceToTextParser
import com.example.translatorapp.voice_to_text.domain.VoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideFakeTranslateClient(): TranslateClient {
        return FakeTranslateClient()
    }

    @Provides
    @Singleton
    fun provideFakeHistoryDataSource(): HistoryDataSource {
        return FakeHistoryDataSource()
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }

    @Provides
    @Singleton
    fun provideVoiceToTextParser(): VoiceToTextParser {
        return FakeVoiceToTextParser()
    }
}