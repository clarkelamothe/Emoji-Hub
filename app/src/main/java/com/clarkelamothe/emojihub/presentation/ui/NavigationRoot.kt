package com.clarkelamothe.emojihub.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.clarkelamothe.emojihub.presentation.emojis.EmojiScreenRoot
import com.clarkelamothe.emojihub.presentation.intro.IntroScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Emojis.toString()
    ) {
        emojisGraph(navController)
    }
}

private fun NavGraphBuilder.emojisGraph(navController: NavHostController) {
    navigation(
        startDestination = Destination.Intro.toString(),
        route = "emojis"
    ) {
        composable(Destination.Intro.toString()) {
            IntroScreenRoot(
                navigateToEmojis = {
                    navController.navigate(Destination.Emojis.toString())
                }
            )
        }
        composable(
            route = Destination.Emojis.toString(),
        ) {
            EmojiScreenRoot()
        }
    }
}

enum class Destination {
    Intro, Emojis
}
