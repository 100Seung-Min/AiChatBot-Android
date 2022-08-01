package com.example.data.repository

import com.example.data.remote.datasource.LawDataSourceImpl
import com.example.data.remote.request.toRequest
import com.example.data.remote.response.toEntity
import com.example.domain.entity.LawEntity
import com.example.domain.param.LawParam
import com.example.domain.repository.LawRepository
import javax.inject.Inject

class LawRepositoryImpl @Inject constructor(
    private val lawDataSource: LawDataSourceImpl
): LawRepository {
    override suspend fun lawQA(lawParam: LawParam): LawEntity {
        return lawDataSource.lawQA(lawParam.toRequest()).toEntity()
    }
}