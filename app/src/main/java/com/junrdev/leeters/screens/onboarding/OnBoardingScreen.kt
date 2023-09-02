package com.junrdev.leeters.screens.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.junrdev.leeters.App

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    App {
        OnboardingScreen(navController = rememberNavController())
    }
}

@Composable
fun OnboardingScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
//    systemUiController.isStatusBarVisible= false
    systemUiController.setStatusBarColor(color = Color.Transparent)


    val pages = listOf(OnboardingPager.ScreenOne)

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        //horizontal pager

    }
}