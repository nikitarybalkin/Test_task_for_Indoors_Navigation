package com.features.timetable.presentation

import android.os.Build
import android.text.TextUtils.split
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.core.utils.TimeConverter
import com.example.network.data.model.ResponseModel
import com.example.network.data.response.Response
import com.features.timetable.databinding.ItemTimetableBinding

class OneTimetableAdapter (private val response: ResponseModel): RecyclerView.Adapter<OneTimetableViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneTimetableViewHolder {
        val binding = ItemTimetableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OneTimetableViewHolder(binding)
    }

    override fun getItemCount(): Int = response.segments.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: OneTimetableViewHolder, position: Int) {
        holder.binding.let {
            if (response.segments[position].from != null) {
                it.tvPlaceOfDeparture.text = response.segments[position].from.title
            }
            if (response.segments[position].thread.carrier != null) {
                it.tvPerevozchik.text = response.segments[position].thread.carrier.title
            }
            if (response.segments[position].thread.transport_subtype.title != null) {
                it.tvNameOfTransport.text = response.segments[position].thread.transport_subtype.title.toString()
            }
            it.dayOfDeparture.text = response.segments[position].start_date
            it.tvTimeOfDeparture.text = response.segments[position].departure.split("T")[1].substring(0, 5)
            it.tvPlaceOfDeparture.text = response.segments[position].from.title
            it.tvTotalTime.text = TimeConverter().calculateTimeDifference(
                departure = response.segments[position].departure,
                arrival = response.segments[position].arrival
            )

            it.dayOfArrival.text = response.segments[position].arrival.split("T")[0]
            it.tvTimeOfArrival.text = response.segments[position].arrival.split("T")[1].substring(0, 5)
            it.tvPlaceOfArrival.text = response.segments[position].to.title
        }
    }
}
class OneTimetableViewHolder(val binding: ItemTimetableBinding): RecyclerView.ViewHolder(binding.root)