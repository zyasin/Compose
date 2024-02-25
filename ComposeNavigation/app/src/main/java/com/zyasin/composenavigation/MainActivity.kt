package com.zyasin.composenavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zyasin.composenavigation.ui.theme.ComposeNavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // To ensure same NavController instance will be returned across recompositions.
            val navController = rememberNavController()

            ComposeNavigationTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    // Setting Navigation host with the provided NavController instance and for starting destination.
                    NavHost(navController = navController, startDestination = "first") {
                        composable("first") {
                            FirstScreen(navController)
                        }
                        composable("second") {
                            SecondScreen(navController)
                        }
                        composable("third") {
                            ThirdScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("First Screen")
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navHostController.navigate("second") },
                modifier = Modifier.padding(vertical = 20.dp),
            ) {
                Text(text = "Go to Second Screen")
            }

            Button(
                onClick = { navHostController.navigate("third") },
                modifier = Modifier.padding(vertical = 20.dp),
            ) {
                Text(text = "Go to Third Screen")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Second Screen")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navHostController.navigate("first") },
                modifier = Modifier.wrapContentSize(),
            ) {
                Text(
                    text = "Go to First Screen by creating it new on back stack",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Third Screen")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow)
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navHostController.popBackStack() },
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(vertical = 16.dp), // Add padding for spacing
            ) {
                Text(
                    text = "Go to previous First Screen present on back stack",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.White
                )
            }
        }
    }
}


