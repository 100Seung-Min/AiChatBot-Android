package com.example.data.remote.datasource

import com.example.data.remote.api.LawAPI
import com.example.data.remote.request.LawRequest
import com.example.data.remote.response.LawResponse
import javax.inject.Inject

class LawDataSourceImpl @Inject constructor(
    private val lawAPI: LawAPI
): LawDataSource {
    override suspend fun lawQA(lawRequest: LawRequest): LawResponse {
        return lawAPI.lawQA(lowRequest = lawRequest)
    }
}