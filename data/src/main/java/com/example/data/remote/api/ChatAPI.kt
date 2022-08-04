package com.example.data.remote.api

import com.example.data.remote.request.ChatOpenRequest
import com.example.data.remote.response.ChatOpenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatAPI {
    @POST("Dialog")
    suspend fun chatOpen(
        @Body chatOpenRequest: ChatOpenRequest
    ): ChatOpenResponse
}