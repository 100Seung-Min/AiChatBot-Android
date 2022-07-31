package com.example.data.remote.api

import com.example.data.remote.request.WikiRequest
import com.example.data.remote.response.WikiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface WikiAPI {

    @POST("WikiQA")
    suspend fun WikiQA(
        @Body wikiRequest: WikiRequest
    ): WikiResponse
}