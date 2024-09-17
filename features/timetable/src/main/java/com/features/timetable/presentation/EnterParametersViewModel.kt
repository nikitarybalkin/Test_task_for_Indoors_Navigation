package com.features.timetable.presentation

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.TransportTypes
import com.example.network.data.model.ResponseModel
import com.example.network.domain.YandexUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

class EnterParametersViewModel @Inject constructor(private val yandexUseCase: YandexUseCase) : ViewModel() {

    val timetable: MutableStateFlow<ResponseModel?> = MutableStateFlow(null)
    var transport: TransportTypes = TransportTypes.any
    var date: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().time)
    fun sendDataToServer() {
        viewModelScope.launch {
            try {
                if (transport == TransportTypes.any) {
                    timetable.value = yandexUseCase.yandexRepository.getTimetable(
                        to = "c213",
                        from = "c146",
                        date = date,
                        apiKey = "cab52a0e-7956-40e0-9f37-772f652598a9"
                    )
                } else {
                    timetable.value = yandexUseCase.yandexRepository.getTimetable(
                        to = "c213",
                        from = "c146",
                        date = date,
                        transportTypes = transport.name,
                        apiKey = "cab52a0e-7956-40e0-9f37-772f652598a9"
                    )
                }
            } catch (e: Exception) {
            }
        }
    }

}