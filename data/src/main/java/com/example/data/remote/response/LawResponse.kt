package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class LawResponse(
    @SerializedName("result")
    val result: Int,
    @SerializedName("return_object")
    val returnObject: ReturnObject
) {
    data class ReturnObject(
        @SerializedName("LegalInfo")
        val legalInfo: LegalInfo
    ) {
        data class LegalInfo(
            @SerializedName("AnswerInfo")
            val answerInfo: List<AnswerInfo>,
            @SerializedName("RelatedQs")
            val RelatedQs: List<String>
        ) {
            data class AnswerInfo(
                @SerializedName("rank")
                val rank: Float,
                @SerializedName("answer")
                val answer: String,
                @SerializedName("source")
                val source: String,
                @SerializedName("clause")
                val clause: String,
                @SerializedName("confidence")
                val confidence: Float
            )
        }
    }
}
