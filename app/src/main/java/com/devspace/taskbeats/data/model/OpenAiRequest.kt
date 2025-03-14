package com.devspace.taskbeats.data.model

data class OpenAiRequest(

    val model: String,
    val messages: List<Message>,
    val store: Boolean = false,
    val max_tokens: Int = 50,
    val temperature: Double? = null
)
