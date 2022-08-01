package com.example.domain.entity

data class LawEntity(
    val result: Int,
    val returnObject: ReturnObject
) {
    data class ReturnObject(
        val legalInfo: LegalInfo
    ) {
        data class LegalInfo(
            val answerInfo: List<AnswerInfo>,
            val relatedQs: List<String>
        ) {
            data class AnswerInfo(
                val rank: Float,
                val answer: String,
                val source: String,
                val clause: String,
                val confidence: Float
            )
        }
    }
}
