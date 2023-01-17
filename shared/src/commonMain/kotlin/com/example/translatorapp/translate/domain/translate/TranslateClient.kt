package com.example.translatorapp.translate.domain.translate

import com.example.translatorapp.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}