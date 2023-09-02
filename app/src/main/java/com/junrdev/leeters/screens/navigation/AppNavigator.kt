package com.junrdev.leeters.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.junrdev.leeters.screens.navigation.Screens.*
import com.junrdev.leeters.screens.onboarding.OnboardingScreen

enum class Screens {
    ONBOARDING,

    SIGN_UP,
    LOGIN;
}


@Composable
fun AppNavigator() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ONBOARDING.name){

        composable(route = ONBOARDING.name){
            OnboardingScreen(navController = navController)
        }

    }
}