package com.example.network.di

import com.example.network.data.YandexDataSource
import com.example.network.data.YandexDataSourceImpl
import com.example.network.data.YandexRepositoryImpl
import com.example.network.data.YandexTimetableAPI
import com.example.network.domain.YandexRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.rasp.yandex.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesYandexTimetableApi(retrofit: Retrofit): YandexTimetableAPI {
        return retrofit.create(YandexTimetableAPI::class.java)
    }

    @Provides
    fun providesYandexDataSource(yandexDataSourceImpl: YandexDataSourceImpl): YandexDataSource {
        return yandexDataSourceImpl
    }

    @Provides
    fun providesYandexRepository(yandexRepositoryImpl: YandexRepositoryImpl): YandexRepository {
        return yandexRepositoryImpl
    }
}