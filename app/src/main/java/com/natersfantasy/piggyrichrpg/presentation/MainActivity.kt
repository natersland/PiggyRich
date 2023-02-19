package com.natersfantasy.piggyrichrpg.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.natersfantasy.piggyrichrpg.presentation.newmember.NewMemberScreen
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
                    startDestination = Routes.NEW_MEMBER
                ) {
                    composable(Routes.NEW_MEMBER) {
                        NewMemberScreen(onPopBackStack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}
