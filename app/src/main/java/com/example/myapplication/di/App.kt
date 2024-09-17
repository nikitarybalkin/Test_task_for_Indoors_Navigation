package com.example.myapplication.di

import android.app.Application
import com.features.timetable.di.TimetableComponent
import com.features.timetable.di.TimetableComponentProvider

class App: Application(), TimetableComponentProvider {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun provideTimetableComponent(): TimetableComponent {
        return component.timetableComponent().create()
    }
}