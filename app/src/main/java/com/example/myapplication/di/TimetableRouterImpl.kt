package com.example.myapplication.di

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.myapplication.R
import com.features.timetable.presentation.TimetableRouter
import javax.inject.Inject

class TimetableRouterImpl @Inject constructor(): TimetableRouter {
    override fun goToTimetableFragment(fragment: Fragment, date: String, transport: String) {
        val bundle = Bundle()
        bundle.putString("date", date)
        bundle.putString("transport", transport)
        findNavController(fragment).navigate(R.id.action_enterParametersFragment_to_timetableFragment, bundle)
    }
}