package com.natersfantasy.piggyrichrpg.scence

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.natersfantasy.piggyrichrpg.scence.splashscreen.SplashScreen
import com.natersfantasy.piggyrichrpg.scence.userdetail.UserDetailScreen

@Composable
fun PiggyPigApp() {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable(route = "SplashScreen") {
            SplashScreen()
        }
        composable(route = "UserDetail") {
            UserDetailScreen()
        }
        composable(route = "UserResult") {}
        composable(route = "Home") {}
        composable(route = "Level1Challenge") {}
        composable(route = "Level2Challenge") {}
        composable(route = "Level3Challenge") {}
        composable(route = "Level4Challenge") {}
        composable(route = "Level5Challenge") {}
        composable(route = "Level6Challenge") {}
        composable(route = "Badge") {}
        composable(route = "Setting") {}
    }
}