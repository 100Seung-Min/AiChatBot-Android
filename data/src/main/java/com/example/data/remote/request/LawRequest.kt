package com.example.data.remote.request

import com.example.domain.param.LawParam
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

fun LawParam.toRequest() = LawRequest(
    accessKey = access_key,
    argument = argument.toRequest()
)

fun LawParam.Argument.toRequest() = LawRequest.Argument(
    question = question
)