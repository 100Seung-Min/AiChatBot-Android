package com.example.data.remote.datasource

import com.example.data.remote.request.WikiRequest
import com.example.data.remote.response.WikiResponse

interface WikiDataSource {
    suspend fun wikiQA(wikiRequest: WikiRequest): WikiResponse
}