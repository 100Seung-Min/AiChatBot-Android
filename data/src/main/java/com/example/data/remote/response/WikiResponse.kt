package com.example.data.remote.response

import com.example.domain.entity.WikiEntity
import com.google.gson.annotations.SerializedName

data class WikiResponse(
    @SerializedName("result")
    val result: Int,
    @SerializedName("return_object")
    val returnObject: ReturnObject
) {
    data class ReturnObject(
        @SerializedName("WiKiInfo")
        val wiKiInfo: WiKiInfo
    ) {
        data class WiKiInfo(
            @SerializedName("IRInfo")
            val iRInfo: List<IRInfo>,
            @SerializedName("AnswerInfo")
            val answerInfo: List<AnswerInfo>
        ) {
            data class IRInfo(
                @SerializedName("wiki_title")
                val wikiTitle: String,
                @SerializedName("sent")
                val sent: String,
                @SerializedName("url")
                val url: String
            )
            fun IRInfo.toEntity() = WikiEntity.ReturnObject.WiKiInfo.IRInfo(
                wikiTitle = wikiTitle,
                sent = sent,
                url = url
            )

            data class AnswerInfo(
                @SerializedName("rank")
                val rank: Float,
                @SerializedName("answer")
                val answer: String,
                @SerializedName("confidence")
                val confidence: Float,
                @SerializedName("url")
                val url: List<String>
            )
            fun AnswerInfo.toEntity() = WikiEntity.ReturnObject.WiKiInfo.AnswerInfo(
                rank = rank,
                answer = answer,
                confidence = confidence,
                url = url
            )
        }
        fun WiKiInfo.toEntity() = WikiEntity.ReturnObject.WiKiInfo(
            iRInfo = iRInfo.map { it.toEntity() },
            answerInfo = answerInfo.map { it.toEntity() }
        )
    }
    fun ReturnObject.toEntity() = WikiEntity.ReturnObject(
        wiKiInfo = wiKiInfo.toEntity()
    )
}
fun WikiResponse.toEntity() = WikiEntity(
    result = result,
    returnObject = returnObject.toEntity()
)