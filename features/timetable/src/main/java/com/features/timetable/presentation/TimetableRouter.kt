package com.features.timetable.presentation

import androidx.fragment.app.Fragment

interface TimetableRouter {
    fun goToTimetableFragment(fragment: Fragment, date: String, transport: String)
}