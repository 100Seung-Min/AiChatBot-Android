package com.example.data.remote.request

import com.google.gson.annotations.SerializedName

data class LawRequest(
    @SerializedName("access_key")
    val accessKey: String,
    @SerializedName("argument")
    val argument: Argument
) {
    data class Argument(
        @SerializedName("question")
        val question: String
    )
}