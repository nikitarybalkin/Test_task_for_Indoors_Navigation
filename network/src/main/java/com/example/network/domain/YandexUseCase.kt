package com.example.network.domain

import com.example.network.data.model.ResponseModel
import javax.inject.Inject

class YandexUseCase @Inject constructor(val yandexRepository: YandexRepository) {
    suspend fun getTimetable(
        apiKey: String = "cab52a0e-7956-40e0-9f37-772f652598a9",
        from: String,
        to: String,
        date: String,
        transportTypes: String = ""
    ): ResponseModel {
        return yandexRepository.getTimetable(
            apiKey,
            from,
            to,
            date,
            transportTypes
        )
    }
}