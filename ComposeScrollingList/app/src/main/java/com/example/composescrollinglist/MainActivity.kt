package com.example.composescrollinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScrollableListExample()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ScrollableListExample() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
    var items by remember { mutableStateOf(emptyList<String>()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Add New Item") },
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = {
                    if (textFieldValue.text.isNotBlank()) {
                        items = items + textFieldValue.text
                        textFieldValue = TextFieldValue()
                    }
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (textFieldValue.text.isNotBlank()) {
                    items = items + textFieldValue.text
                    textFieldValue = TextFieldValue()
                }
            }
        ) {
            Text("Add Item")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            contentPadding = PaddingValues(vertical = 2.dp) // Reduced spacing between rows
        ) {
            itemsIndexed(items) { index, item ->
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp) // Adjust padding for the ListItem
                        .background(Color.Cyan)
                ) {
                    Text(
                        text = item,
                        fontSize = 15.sp,  // Default font size for list items
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .height(20.dp) // Height of the shaded area
                    )
                }
            }
        }
    }
}


@Composable
fun ListItem(modifier: Modifier = Modifier, text: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        text()
    }
}