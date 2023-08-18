package com.example.testapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapplication.ui.theme.TestApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .padding(30.dp)
                                .shadow(8.dp)
                                .background(Color(0xFFFFF9C4))
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 16.dp, vertical = 16.dp)
                        ) {
                            Column {
                                Text(
                                    text = "Username",
                                    color = Color.DarkGray,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                TextField(
                                    value = "",
                                    onValueChange = { /* TODO: Handle username change */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(46.dp)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Password",
                                    color = Color.DarkGray,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                TextField(
                                    value = "",
                                    onValueChange = { /* TODO: Handle password change */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(46.dp)
                                )
                                Button(
                                    onClick = { /* TODO: Handle login button click */ },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 30.dp, bottom = 8.dp)
                                        .height(46.dp)
                                ) {
                                    Text(text = "Login", fontSize = 18.sp)
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, bottom = 8.dp)
                                ) {
                                    Text(
                                        text = "Cancel",
                                        color = Color.Blue,
                                        modifier = Modifier
                                            .clickable { /* TODO: Handle Cancel click */ }
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "Reset Password",
                                        color = Color.Blue,
                                        modifier = Modifier
                                            .clickable { /* TODO: Handle Reset Password click */ }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


