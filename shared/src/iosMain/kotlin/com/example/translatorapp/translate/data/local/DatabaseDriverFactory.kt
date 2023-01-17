package com.example.translatorapp.translate.data.local

import com.example.translatorapp.database.TranslateDataBase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TranslateDataBase.Schema, "translate.db")
    }
}