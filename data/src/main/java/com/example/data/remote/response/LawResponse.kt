package com.example.data.remote.response

import com.example.domain.entity.LawEntity
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
            val relatedQs: List<String>
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

            fun AnswerInfo.toEntity() = LawEntity.ReturnObject.LegalInfo.AnswerInfo(
                rank = rank,
                answer = answer,
                source = source,
                clause = clause,
                confidence = confidence
            )
        }

        fun LegalInfo.toEntity() = LawEntity.ReturnObject.LegalInfo(
            answerInfo = answerInfo.map { it.toEntity() },
            relatedQs = relatedQs
        )
    }

    fun ReturnObject.toEntity() = LawEntity.ReturnObject(
        legalInfo = legalInfo.toEntity()
    )
}

fun LawResponse.toEntity() = LawEntity(
    result = result,
    returnObject = returnObject.toEntity()
)
