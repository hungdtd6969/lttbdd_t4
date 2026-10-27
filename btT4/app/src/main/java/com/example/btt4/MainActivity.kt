package com.example.btt4

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
import com.example.btt4.ui.theme.BtT4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BtT4Theme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf(1) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Crossfade( //Crossfade tạo hiệu ứng chuyển cảnh bằng cách làm mờ dần màn hình cũ và hiện dần màn hình mới.
            targetState = currentScreen,
            modifier = Modifier.padding(innerPadding),
        ) { screen ->
            when (screen) {
                1 -> Screen1(
                    onNext = { currentScreen = 2 }
                )
                2 -> Screen2(
                    onNext = { currentScreen = 3 },
                    onSkip = { currentScreen = 1 }
                )
                3 -> Screen3(
                    onNext = { currentScreen = 4 },
                    onSkip = { currentScreen = 1 }
                )
                4 -> Screen4(
                    onStart = { currentScreen = 1 },
                    onSkip = { currentScreen = 1 }
                )
            }
        }
    }
}
