package com.example.data.remote.request

import com.example.domain.param.WikiParam
import com.google.gson.annotations.SerializedName

data class WikiRequest(
    @SerializedName("access_key")
    val access_key: String,
    @SerializedName("argument")
    val argument: Argument
) {
    data class Argument(
        @SerializedName("question")
        val question: String,
        @SerializedName("type")
        val type: String
    )
}

fun WikiParam.toRequest() = WikiRequest(
    access_key = access_key,
    argument = argument.toRequest()
)

fun WikiParam.Argument.toRequest() = WikiRequest.Argument(
    question = question,
    type = type
)
