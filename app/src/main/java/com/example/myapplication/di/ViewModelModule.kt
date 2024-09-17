package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import com.features.timetable.presentation.EnterParametersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    @IntoMap
    @StringKey("EnterParametersViewModel")
    @Binds
    fun bindsEnterParametersViewModel(impl: EnterParametersViewModel): ViewModel

    /*@IntoMap
    @StringKey("VerificationCodeViewModel")
    @Binds
    fun bindsVerificationCodeViewModel(impl: VerificationCodeViewModel): ViewModel

    @IntoMap
    @StringKey("MainViewModel")
    @Binds
    fun bindsMainViewModel(impl: MainViewModel): ViewModel

    @IntoMap
    @StringKey("ResponseViewModel")
    @Binds
    fun bindsResponseViewModel(impl: ResponseViewModel): ViewModel

    @IntoMap
    @StringKey("FullVacancyViewModel")
    @Binds
    fun bindsFullVacancyViewModel(impl: FullVacancyViewModel): ViewModel

    @IntoMap
    @StringKey("FavoritesViewModel")
    @Binds
    fun bindsFavoritesViewModel(impl: FavoritesViewModel): ViewModel*/

}