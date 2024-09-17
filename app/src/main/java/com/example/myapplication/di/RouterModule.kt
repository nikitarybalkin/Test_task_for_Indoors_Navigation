package com.example.myapplication.di

import com.features.timetable.presentation.TimetableRouter
import dagger.Module
import dagger.Provides

@Module
class RouterModule {
    @Provides
    fun providesTimetableRouter(timetableRouterImpl: TimetableRouterImpl): TimetableRouter {
        return timetableRouterImpl
    }
}