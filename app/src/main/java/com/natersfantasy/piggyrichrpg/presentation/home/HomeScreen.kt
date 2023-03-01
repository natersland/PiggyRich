package com.natersfantasy.piggyrichrpg.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.natersfantasy.piggyrichrpg.data.game.levelList
import com.natersfantasy.piggyrichrpg.presentation.home.viewmodel.HomeEvent
import com.natersfantasy.piggyrichrpg.presentation.home.viewmodel.HomeViewModel
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme
import com.natersfantasy.piggyrichrpg.util.UiEvent
import kotlinx.coroutines.flow.StateFlow
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.data.game.Level
import com.natersfantasy.piggyrichrpg.presentation.home.components.CurrentChallenge
import com.natersfantasy.piggyrichrpg.presentation.home.components.HomeHeader
import com.natersfantasy.piggyrichrpg.presentation.home.components.SavingCard


data class HomeScreenViewState(
    val userLevel: String,
    val userName: String,
    val savingAmount: Int,
    val userColor: Color,
    val userMascotResId: Int,
    val currentChallenge: List<Level> = emptyList()
)

sealed interface HomeScreenViewAction {
    object OnClickCurrentChallenge : HomeScreenViewAction
    object OnClickChallenge : HomeScreenViewAction
    object OnClickBadgeIcon : HomeScreenViewAction
}

sealed interface HomeScreenViewEffect {

}

interface HomeScreenViewModel {
    val state: StateFlow<HomeScreenViewState>
    val effect: StateFlow<HomeScreenViewEffect>

    fun dispatch(action: HomeScreenViewAction)
}
//
//@Composable
//internal fun HomeScreen(
//    onNavigate: (UiEvent.Navigate) -> Unit,
//    viewModel: HomeViewModel = hiltViewModel()
//) {
//
//    LaunchedEffect(key1 = true) {
//        viewModel.uiEvent.collect { event ->
//            when (event) {
//                is UiEvent.Navigate -> onNavigate(event)
//                else -> Unit
//            }
//
//        }
//    }
//
//    LaunchedEffect(key1 = true) {
//        viewModel.onEvent(HomeEvent.OnHandleMascotLevel)
//        viewModel.onEvent(HomeEvent.OnHandleColorBgLevel)
//        viewModel.onEvent(HomeEvent.OnHandleCurrentLevel)
//    }
//
//
//
//    Column(
//        Modifier
//            .fillMaxSize()
//            .padding(24.dp)) {
//
//    }
//}

@Composable
fun HomeScreen(
    state: HomeScreenViewState,
    dispatch: (HomeScreenViewAction) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            HomeHeader(
                modifier = Modifier,
                userLevel = state.userLevel,
                userName = state.userName,
                userColor = state.userColor
            )
            Column() {
                Spacer(modifier = Modifier.padding(top = 170.dp))
                SavingCard(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    userColor = state.userColor,
                    userMascot = state.userMascotResId,
                    savingAmount = state.savingAmount
                )
            }
        }
        CurrentChallenge(modifier = Modifier.padding(24.dp), currentChallenge = state.currentChallenge[0])
    }

}

@Preview(showBackground = true, locale = "th")
@Composable
fun HomeScreenPreview() {

    PiggyRichRPGTheme() {
        HomeScreen(state = HomeScreenViewState(
            userLevel = "1",
            userName = "ลำดวน",
            savingAmount = 55555,
            userColor = PiggyRichColor.Chicken,
            userMascotResId = R.drawable.char_chicken,
            currentChallenge = levelList
        ), dispatch = {})
    }
}