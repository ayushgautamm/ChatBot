package com.example.chatbot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbot.ChatData
import com.example.chatbot.ChatRoleEnum

@Composable
fun Chatlist(list: MutableList<ChatData>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items
    ) {
        items(list) { chatData ->
            if (chatData.role == ChatRoleEnum.USER.role) {
                // User message UI
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End // Align messages to the right
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        ),
                        modifier = Modifier
                            .widthIn(max = 280.dp) // Limit the width for readability
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = chatData.message,
                            modifier = Modifier
                                .padding(12.dp),
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            } else {
                // Bot message UI
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start // Align messages to the left
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.LightGray
                        ),
                        modifier = Modifier
                            .widthIn(max = 280.dp) // Limit the width for readability
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = chatData.message,
                            modifier = Modifier
                                .padding(12.dp),
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}
