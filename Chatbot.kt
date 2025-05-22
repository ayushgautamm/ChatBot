package com.example.chatbot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbot.components.ChatFooter
import com.example.chatbot.components.ChatHeader
import com.example.chatbot.components.Chatlist

@Composable
fun Chatbot(
    viewModel: ChatbotVM = viewModel() // ViewModel instance
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Header at the top
        ChatHeader()

        // Chat list (sho   wing messages)
        Box(modifier = Modifier.weight(1f)) {
            Chatlist(list = viewModel.list) // Displaying chat messages
        }

        // Footer with input field for sending messages
        ChatFooter {
            if (it.isNotEmpty()) {
                viewModel.sendMessage(it)
            }
        }
    }
}
