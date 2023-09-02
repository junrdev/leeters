package com.junrdev.leeters.screens.onboarding

sealed class OnboardingPager(
    val image: Int?,
    val animation: Int?,
    val title: String,
    val description: String,
) {

    object ScreenOne : OnboardingPager(
        image = null,
        animation = null,
        title = "Screen 1",
        description = "Screen 1 description"
    )
}
