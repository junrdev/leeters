package com.junrdev.leeters.ui.util

import androidx.navigation.NavController

data class UIEvent(
    val navController: NavController
);

sealed class EventHandler(
    val event : UIEvent
){

    fun HandleEvent(event: UIEvent){

        when (event){


        }
    }
}
