package com.zyasin.topappbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TopBar()
        }
    }
}

@Composable
fun FloatingActionButtonExample(onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                FloatingActionButton(
                    onClick = onClick,
                    shape = CircleShape,
                    containerColor = Color.Red,
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.Red, CircleShape)
                ) {
                    Icon(Icons.Filled.Add, "Floating action button", tint = White)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {

            CenterAlignedTopAppBar(

                title = {

                    Text(
                        text = "Appbar Title",
                        maxLines = 1 // Title constrained to be within a line.
                    )
                },

                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation click */ }) {
                        Icon(Icons.Default.ArrowBack, "backIcon")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle overflow menu click */ }) {
                        Icon(Icons.Default.Menu, "overflowMenu")
                    }

                },

                )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF006400)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Add your content here",
                    fontSize = 21.sp,
                    color = Color.White
                )
            }

            FloatingActionButtonExample(onClick = {
                // Log message for demo purpose. Add your custom logic here.
                Log.d("ButtonClicked", "floating action button clicked")

            })

        })
}