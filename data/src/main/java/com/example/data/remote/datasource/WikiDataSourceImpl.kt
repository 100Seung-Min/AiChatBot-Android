package com.example.data.remote.datasource

import com.example.data.remote.api.WikiAPI
import com.example.data.remote.request.WikiRequest
import com.example.data.remote.response.WikiResponse
import javax.inject.Inject

class WikiDataSourceImpl @Inject constructor(
    private val wikiAPI: WikiAPI
): WikiDataSource {
    override suspend fun wikiQA(wikiRequest: WikiRequest): WikiResponse {
        return wikiAPI.wikiQA(wikiRequest = wikiRequest)
    }
}