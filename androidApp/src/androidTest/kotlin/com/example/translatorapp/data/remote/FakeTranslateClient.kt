package com.example.translatorapp.data.remote

import com.example.translatorapp.core.domain.language.Language
import com.example.translatorapp.translate.domain.translate.TranslateClient

class FakeTranslateClient : TranslateClient {

    var translatedText = "test translation"

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        return translatedText
    }
}