package com.example.domain.entity

data class WikiEntity(
    val result: Int,
    val returnObject: ReturnObject
) {
    data class ReturnObject(
        val wiKiInfo: WiKiInfo
    ) {
        data class WiKiInfo(
            val iRInfo: List<IRInfo>,
            val answerInfo: List<AnswerInfo>
        ) {
            data class IRInfo(
                val wikiTitle: String,
                val sent: String,
                val url: String
            )

            data class AnswerInfo(
                val rank: Float,
                val answer: String,
                val confidence: Float,
                val url: List<String>
            )
        }
    }
}
