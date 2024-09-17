package com.example.network.data

import com.example.network.data.response.Response
import javax.inject.Inject

class YandexDataSourceImpl @Inject constructor(val yandexAPI: YandexTimetableAPI): YandexDataSource {
    override suspend fun getTimetable(
        apiKey: String,
        from: String,
        to: String,
        date: String,
        transportTypes: String
    ): Response {
         return yandexAPI.getTimetable(
            apiKey = apiKey,
            from =  from,
            to = to,
            date = date,
            transportTypes = transportTypes
        )
    }
}