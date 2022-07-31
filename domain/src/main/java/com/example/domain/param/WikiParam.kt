package com.example.domain.param

data class WikiParam(
    val access_key: String,
    val argument: Question
) {
    data class Question(
        val question: String,
        val type: String
    )
}