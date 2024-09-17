package com.example.network.data

import com.example.network.data.model.ResponseModel
import com.example.network.data.model.mapToDomain
import com.example.network.domain.YandexRepository
import javax.inject.Inject

class YandexRepositoryImpl @Inject constructor(val yandexDataSource: YandexDataSource): YandexRepository {
    override suspend fun getTimetable(
        apiKey: String,
        from: String,
        to: String,
        date: String,
        transportTypes: String
    ): ResponseModel {
        return yandexDataSource.getTimetable(
            apiKey,
            from,
            to,
            date,
            transportTypes
        ).mapToDomain()
    }
}