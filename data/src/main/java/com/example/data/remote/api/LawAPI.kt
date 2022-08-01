package com.example.data.remote.api

import com.example.data.remote.request.WikiRequest
import com.example.data.remote.response.LawResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LawAPI {
    @POST("LegalQA")
    suspend fun LawQA(
        @Body lowRequest: WikiRequest
    ): LawResponse
}