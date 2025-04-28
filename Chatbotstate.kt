package com.example.chatbot

sealed class ChatBotuiState {
    object Ideal : ChatBotuiState()
    object Loading : ChatBotuiState()
    data class Success(val chatData: String) : ChatBotuiState()
    data class Error(val chatError: String) : ChatBotuiState()
}
