package com.example.myapplication.di

import android.content.Context
import com.example.network.di.NetworkModule
import com.features.timetable.di.TimetableComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class, NetworkModule::class, RouterModule::class])
interface ApplicationComponent {
    fun timetableComponent(): TimetableComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}