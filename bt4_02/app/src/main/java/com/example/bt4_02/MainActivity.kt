package com.example.bt4_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bt4_02.ui.theme.Bt4_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bt4_02Theme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf(1) }
    var userData by remember { mutableStateOf(UserData()) }
    var submittedData by remember { mutableStateOf<UserData?>(null) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Crossfade(
            targetState = currentScreen,
            modifier = Modifier.padding(innerPadding)
        ) { screen ->
            when (screen) {
                1 -> Screen1(
                    initialEmail = userData.email,
                    submittedData = submittedData,
                    onNext = { email ->
                        userData = userData.copy(email = email)
                        currentScreen = 2
                    }
                )

                2 -> Screen2(
                    initialOtp = userData.otp,
                    onBack = { currentScreen = 1 },
                    onNext = { otp ->
                        userData = userData.copy(otp = otp)
                        currentScreen = 3
                    }
                )

                3 -> Screen3(
                    initialPassword = userData.password,
                    onBack = { currentScreen = 2 },
                    onNext = { password ->
                        userData = userData.copy(password = password)
                        currentScreen = 4
                    }
                )

                4 -> Screen4(
                    userData = userData,
                    onBack = { currentScreen = 3 },
                    onSubmit = {
                        submittedData = userData
                        currentScreen = 1
                    }
                )
            }
        }
    }
}
