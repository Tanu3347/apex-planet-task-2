package com.cscorner.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import screens.WelcomeScreen
import screens.RegistrationScreen

private val AppBackground = Color(0xFFF7F8F5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppBackground
                ) {
                    var currentScreen by remember {
                        mutableStateOf("welcome")
                    }

                    when (currentScreen) {
                        "welcome" -> WelcomeScreen(
                            onGetStarted = {
                                currentScreen = "register"
                            }
                        )

                        "register" -> RegistrationScreen(
                            onBack = {
                                currentScreen = "welcome"
                            },
                            onRegistrationComplete = {
                                currentScreen = "welcome"
                            }
                        )
                    }
                }
            }
        }
    }
}
