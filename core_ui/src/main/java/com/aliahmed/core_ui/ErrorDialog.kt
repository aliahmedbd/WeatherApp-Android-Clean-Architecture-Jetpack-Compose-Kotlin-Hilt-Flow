package com.aliahmed.core_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorDialog(message: String?, onDismiss: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onDismiss()
            },
            title = {
                Text(
                    text ="An unexpected error occurred",
                    color = Color.Black
                )
            },
            text = {
                message?.let { Text(it,  color = Color.Black) }
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp, 12.dp, 12.dp, 24.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(modifier = Modifier,
                        onClick = {
                            openDialog.value = false
                            onDismiss()
                        }) {
                        Text(text = "Dismiss", color = MaterialTheme.colors.onBackground)
                    }
                }
            }
        )
    }
}