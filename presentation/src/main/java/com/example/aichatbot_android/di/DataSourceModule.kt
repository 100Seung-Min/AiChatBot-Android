package com.example.aichatbot_android.di

import com.example.data.remote.api.LawAPI
import com.example.data.remote.api.WikiAPI
import com.example.data.remote.datasource.LawDataSourceImpl
import com.example.data.remote.datasource.WikiDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideWikiDataSource(service: WikiAPI) = WikiDataSourceImpl(service)

    @Provides
    @Singleton
    fun provideLawDataSource(service: LawAPI) = LawDataSourceImpl(service)
}