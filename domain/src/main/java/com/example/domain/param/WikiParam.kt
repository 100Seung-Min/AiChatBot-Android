package com.example.domain.param

data class WikiParam(
    val access_key: String,
    val argument: Argument
) {
    data class Argument(
        val question: String,
        val type: String
    )
}