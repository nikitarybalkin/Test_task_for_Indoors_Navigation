package com.example.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TimeConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateTimeDifference(departure: String, arrival: String): String {
        val formatter = DateTimeFormatter.ISO_DATE_TIME

        // Время отправления и прибытия
        val departureTime = LocalDateTime.parse(departure, formatter)
        val arrivalTime = LocalDateTime.parse(arrival, formatter)

        // Рассчитываем продолжительность
        val duration = Duration.between(departureTime, arrivalTime)

        // Извлекаем часы и минуты
        val hours = duration.toHours()
        val minutes = duration.toMinutes() % 60

        return "${hours}ч ${minutes}м"
    }
}