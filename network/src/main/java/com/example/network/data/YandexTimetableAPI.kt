package com.example.network.data

import com.example.network.data.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexTimetableAPI {
    @GET("v3.0/search/")
    suspend fun getTimetable(
        @Query("apikey") apiKey: String = "cab52a0e-7956-40e0-9f37-772f652598a9",
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("date") date: String,
        @Query("transport_types") transportTypes: String = ""
    ): Response
}