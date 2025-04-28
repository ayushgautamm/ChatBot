package com.example.chatbot

import androidx.compose.ui.semantics.Role
import androidx.core.app.NotificationCompat.MessagingStyle.Message

data class ChatData(
    val message: String,
    val role: String
)

enum class ChatRoleEnum(val role: String) {
    USER("user"),
    MODEL("model")
}

