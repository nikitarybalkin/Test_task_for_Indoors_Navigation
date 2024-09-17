package com.example.network.domain

import com.example.network.data.model.ResponseModel

interface YandexRepository {
    suspend fun getTimetable(
        apiKey: String,
        from: String,
        to: String,
        date: String,
        transportTypes: String = ""
    ): ResponseModel
}