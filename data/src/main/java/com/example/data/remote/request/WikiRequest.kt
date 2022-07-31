package com.example.data.remote.request

import com.google.gson.annotations.SerializedName

data class WikiRequest(
    @SerializedName("access_key")
    val access_key: String = "24049d6a-b054-4a8d-909d-af913c5e2bba",
    @SerializedName("argument")
    val argument: Question
)

data class Question(
    @SerializedName("question")
    val question: String,
    @SerializedName("type")
    val type: String
)
