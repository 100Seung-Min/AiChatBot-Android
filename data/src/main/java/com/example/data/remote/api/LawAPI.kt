package com.example.data.remote.api

import com.example.data.remote.request.LawRequest
import com.example.data.remote.response.LawResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LawAPI {
    @POST("LegalQA")
    suspend fun lawQA(
        @Body lowRequest: LawRequest
    ): LawResponse
}