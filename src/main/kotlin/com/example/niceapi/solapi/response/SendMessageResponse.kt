package com.example.niceapi.solapi.response

data class SendMessageResponse(
    val groupId: String,
    val messageId: String,
    val accountId: String,
    val statusMessage: String,
    val statusCode: String,
    val to: String,
    val from: String,
    val type: String,
    val country: String
)