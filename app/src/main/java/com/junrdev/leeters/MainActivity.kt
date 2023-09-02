package com.junrdev.leeters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.junrdev.leeters.screens.navigation.AppNavigator
import com.junrdev.leeters.ui.theme.LeetersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //optional
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            App {
                AppNavigator()
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    LeetersTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeetersTheme {
        AppNavigator()
    }
}