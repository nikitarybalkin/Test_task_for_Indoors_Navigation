package com.features.timetable.di

import com.features.timetable.presentation.EnterParametersFragment
import com.features.timetable.presentation.TimetableFragment
import dagger.Subcomponent

@Subcomponent
interface TimetableComponent {
    fun inject(enterParametersFragment: EnterParametersFragment)
    fun inject(timetableFragment: TimetableFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TimetableComponent
    }
}