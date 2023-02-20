package com.natersfantasy.piggyrichrpg.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.presentation.home.viewmodel.HomeViewModel
import com.natersfantasy.piggyrichrpg.util.UiEvent


@Composable
internal fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }

        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        HomeHeader(viewModel)
//        SavingCard(viewModel)
//        CurrentChallenge(viewModel)
//        AllChallenge()
    }
}

@Composable
fun HomeHeader(viewModel: HomeViewModel) {
    Box(modifier = Modifier.fillMaxWidth()) {
        val userColor = viewModel.userBgColor
        Card(backgroundColor = userColor, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Test")
            Column() {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Go to Badge Screen"
                    )
                    Text(text = "Level 1")
                }
                Text(text = "UserName")
            }
        }

    }
}

@Composable
fun SavingCard(viewModel: HomeViewModel) {
    val userMascot = viewModel.userMascot
    val userSavingAmount = viewModel.savingAmount.toString()

    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = userMascot),
            contentDescription = "User Animal Mascot"
        )
        Card() {
            Column() {
                Text(text = stringResource(id = R.string.home_your_current_saving_text))
                Text(text = userSavingAmount)
                Text(text = stringResource(id = R.string.bath))
            }
        }
    }
}

@Composable
fun CurrentChallenge(viewModel: HomeViewModel) {
    val userCurrentChallenge = viewModel.userLevel

    Box(modifier = Modifier.fillMaxWidth()) {
//        LazyColumn() {
//            Text(text = stringResource(id = R.string.home_current_challenge))
//            // TODO Handle to show current challenge
//        }
    }
}

@Composable
fun AllChallenge() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column() {
            Text(text = stringResource(id = R.string.home_all_challenge))
        }
    }
}

@Preview(showBackground = true, locale = "th")
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}