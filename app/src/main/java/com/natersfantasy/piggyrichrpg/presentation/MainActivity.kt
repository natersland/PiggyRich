package com.natersfantasy.piggyrichrpg.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.android.showkase.models.Showkase
import com.natersfantasy.piggyrichrpg.presentation.home.HomeScreen
import com.natersfantasy.piggyrichrpg.presentation.newmember.NewMemberScreen
import com.natersfantasy.piggyrichrpg.presentation.splashscreen.SplashScreen
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme
import com.natersfantasy.piggyrichrpg.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PiggyRichRPGTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.SPLASH_SCREEN
                ) {
                    composable(Routes.SPLASH_SCREEN) {
                        SplashScreen(
                            onPopBackStack = { navController.popBackStack() },
                            onNavigate = { navController.navigate(it.route) },
                        )
                    }
                    composable(Routes.NEW_MEMBER) {
                        NewMemberScreen(
                            onPopBackStack = { navController.popBackStack() },
                            onNavigate = { navController.navigate(it.route) }
                        )
                    }
                    composable(Routes.HOME) {
//                        HomeScreen(onNavigate = { navController.navigate(it.route) })
                    }
                }
            }
        }
    }
}
