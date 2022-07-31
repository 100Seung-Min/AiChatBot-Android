package com.example.data.repository

import com.example.data.remote.datasource.WikiDataSource
import com.example.data.remote.datasource.WikiDataSourceImpl
import com.example.data.remote.request.toRequest
import com.example.data.remote.response.toEntity
import com.example.domain.entity.WikiEntity
import com.example.domain.param.WikiParam
import com.example.domain.repository.WikiRepository
import javax.inject.Inject

class WikiRepositoryImpl @Inject constructor(
    private val wikiDataSource: WikiDataSourceImpl
): WikiRepository {
    override suspend fun wikiQA(wikiParam: WikiParam): WikiEntity {
        return wikiDataSource.wikiQA(wikiParam.toRequest()).toEntity()
    }
}