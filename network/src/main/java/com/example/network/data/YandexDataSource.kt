package com.example.network.data

import com.example.network.data.response.Response

interface YandexDataSource {
    suspend fun getTimetable(
        apiKey: String,
        from: String,
        to: String,
        date: String,
        transportTypes: String = ""
    ): Response
}