package com.natersfantasy.piggyrichrpg.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.data.game.Level
import com.natersfantasy.piggyrichrpg.presentation.home.components.ChallengeCard
import com.natersfantasy.piggyrichrpg.presentation.home.viewmodel.HomeEvent
import com.natersfantasy.piggyrichrpg.presentation.home.viewmodel.HomeViewModel
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigTypography
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme
import com.natersfantasy.piggyrichrpg.ui.theme.Shapes
import com.natersfantasy.piggyrichrpg.util.UiEvent
import com.natersfantasy.piggyrichrpg.util.addCommasToNumber


@Composable
internal fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }

        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(HomeEvent.OnHandleMascotLevel)
        viewModel.onEvent(HomeEvent.OnHandleColorBgLevel)
        viewModel.onEvent(HomeEvent.OnHandleCurrentLevel)
    }

    val userLevel = viewModel.user?.level.toString()
    val userName = viewModel.user?.name
    val savingAmount = viewModel.user?.savingMoney
    val formattedSavingAmount = addCommasToNumber(savingAmount)
    val userColor = viewModel.userBgColor
    val userMascot = viewModel.userMascot
    val currentChallenge = viewModel.currentChallenge


    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HomeHeader(
            modifier = Modifier
                .fillMaxWidth(),
            userLevel = userLevel,
            userName = userName,
            userColor = userColor
        )
        Column {
            SavingCard(
                modifier = Modifier
                    .fillMaxWidth(),
                userColor = userColor,
                userMascot = userMascot,
                formattedSavingAmount = formattedSavingAmount
            )
            CurrentChallenge(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 300.dp)
                    .padding(horizontal = 24.dp),
                currentChallenge = currentChallenge
            )
//            AllChallenge(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 24.dp)
//                    .offset(y = 300.dp),
//            )
        }
    }
}


@Composable
fun HomeHeader(
    modifier: Modifier,
    userLevel: String,
    userName: String?,
    userColor: Color
) {
    Box(modifier = modifier) {
        Card(
            backgroundColor = userColor,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp)
        ) {
            Column(modifier = Modifier.padding(bottom = 200.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 28.dp, start = 24.dp, end = 24.dp, bottom = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Go to Badge Screen",
                    )
                    Text(
                        text = stringResource(id = R.string.home_user_level, userLevel),
                        style = PiggyPigTypography.h3,
                        color = Color.White
                    )
                }
                Text(
                    text = userName ?: "Unknown",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    textAlign = TextAlign.Center,
                    style = PiggyPigTypography.h1,
                    color = Color.White
                )
            }
        }

    }
}

@Composable
fun SavingCard(
    modifier: Modifier,
    userColor: Color,
    userMascot: Int,
    formattedSavingAmount: String
) {
    Box(modifier = modifier) {
        Card(
            modifier
                .wrapContentSize()
                .padding(bottom = 32.dp, start = 32.dp, end = 32.dp)
                .offset(y = 300.dp),
            shape = Shapes.medium, backgroundColor = Color.White
        ) {
            Column(Modifier.padding(32.dp)) {
                Text(
                    text = stringResource(id = R.string.home_your_current_saving_text),
                    style = PiggyPigTypography.h3,
                    color = PiggyRichColor.Gray818181,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = formattedSavingAmount, style = PiggyPigTypography.h1,
                    color = userColor,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.bath), style = PiggyPigTypography.h4,
                    color = PiggyRichColor.Gray818181,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
        Image(
            painter = painterResource(id = userMascot),
            contentDescription = "User Animal Mascot",
            modifier = modifier
                .offset(y = 170.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun CurrentChallenge(modifier: Modifier, currentChallenge: Level?) {
    val savingGoal = currentChallenge?.savingGoal
    val mascotName = currentChallenge?.mascotName
    val mascotImage = currentChallenge?.mascotImage
    val challengeColor = currentChallenge?.levelColor

    Box(modifier = modifier.fillMaxWidth()) {
        Column() {
            Text(
                text = stringResource(id = R.string.home_current_challenge),
                style = PiggyPigTypography.h4,
                color = PiggyRichColor.Gray818181
            )
            if (mascotImage != null && challengeColor != null && mascotName != null) {
                ChallengeCard(
                    savingGoal = addCommasToNumber(savingGoal),
                    mascotName = stringResource(id = mascotName),
                    mascotImage = mascotImage,
                    challengeColor = challengeColor,
                    isUnlock = true
                )
            }
        }
    }
}

@Composable
fun AllChallenge(modifier: Modifier) {
    Box(modifier = modifier) {

//        LazyColumn() {
//            // TODO Show all challenge with handle isActive status
//        }
    }
}

//@Preview(showBackground = true, locale = "th")
@Composable
fun HomeScreenPreview() {
    PiggyRichRPGTheme() {
        HomeScreen(onNavigate = {})
    }
}