package com.example.chatbot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatbotVM : ViewModel() {
    // MutableStateList to track chat messages for recomposition
    val list = mutableStateListOf<ChatData>()

    // Lazy initialization of the GenerativeModel
    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro", // Ensure this model name is correct
            apiKey = ApiKey // Replace with your actual API key reference
        )
    }

    // Function to send a message and handle the response
    fun sendMessage(message: String) = viewModelScope.launch {
        try {
            // Start a chat session
            val chat: Chat = genAI.startChat()

            // Add the user's message to the list
            list.add(ChatData(message, ChatRoleEnum.USER.role))

            // Send the user's message to the Generative AI model and retrieve the response
            val response = chat.sendMessage(
                content(ChatRoleEnum.USER.role) { text(message) }
            )?.text

            // Add the AI's response to the list if it's not null
            if (!response.isNullOrEmpty()) {
                list.add(ChatData(response, ChatRoleEnum.MODEL.role))
            } else {
                list.add(ChatData("No response from AI.", ChatRoleEnum.MODEL.role))
            }
        } catch (e: Exception) {
            // Log and handle errors
            Log.e("ChatbotVM", "Error in sendMessage: ${e.localizedMessage}")
            list.add(ChatData("Error: ${e.localizedMessage}", ChatRoleEnum.MODEL.role))
        }
    }
}
