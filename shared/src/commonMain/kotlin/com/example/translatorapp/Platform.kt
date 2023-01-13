package com.example.translatorapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform