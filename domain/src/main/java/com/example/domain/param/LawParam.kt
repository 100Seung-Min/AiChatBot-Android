package com.example.domain.param

data class LawParam(
    val access_key: String,
    val argument: Argument
) {
    data class Argument(
        val question: String
    )
}