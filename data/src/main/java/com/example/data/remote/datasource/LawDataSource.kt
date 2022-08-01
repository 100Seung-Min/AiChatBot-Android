package com.example.data.remote.datasource

import com.example.data.remote.request.LawRequest
import com.example.data.remote.response.LawResponse

interface LawDataSource {
    suspend fun lawQA(lawRequest: LawRequest): LawResponse
}