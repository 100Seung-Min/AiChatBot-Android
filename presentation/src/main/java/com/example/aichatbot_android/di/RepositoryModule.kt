package com.example.aichatbot_android.di

import com.example.data.remote.datasource.LawDataSourceImpl
import com.example.data.remote.datasource.WikiDataSourceImpl
import com.example.data.repository.LawRepositoryImpl
import com.example.data.repository.WikiRepositoryImpl
import com.example.domain.repository.LawRepository
import com.example.domain.repository.WikiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWikiRepository(dataSource: WikiDataSourceImpl): WikiRepository = WikiRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideLawRepository(dataSource: LawDataSourceImpl): LawRepository = LawRepositoryImpl(dataSource)
}