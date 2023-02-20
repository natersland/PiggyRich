package com.natersfantasy.piggyrichrpg.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.util.UiEvent


@Composable
internal fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        HomeHeader()
        SavingCard()
        CurrentChallenge()
        AllChallenge()
    }
}

@Composable
fun HomeHeader() {
    Box(modifier = Modifier.fillMaxWidth()) {
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

@Composable
fun SavingCard() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.char_chicken),
            contentDescription = "User Animal Mascot"
        )
        Card() {
            Column() {
                Text(text = stringResource(id = R.string.home_your_current_saving_text))
                Text(text = "30,000 บาท")
                Text(text = stringResource(id = R.string.bath))
            }
        }
    }
}

@Composable
fun CurrentChallenge() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column() {
            Text(text = stringResource(id = R.string.home_current_challenge))
            // TODO Handle to show current challenge
        }
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