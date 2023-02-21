package com.natersfantasy.piggyrichrpg.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigTypography
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.ui.theme.Shapes
import com.natersfantasy.piggyrichrpg.util.UiEvent


@Composable
internal fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
//    viewModel: HomeViewModel = hiltViewModel()
) {
//    LaunchedEffect(key1 = true) {
//        viewModel.uiEvent.collect { event ->
//            when(event) {
//                is UiEvent.Navigate -> onNavigate(event)
//                else -> Unit
//            }
//
//        }
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout() {
            val (
                headerRef,
                savingCardRef,
                currentChallengeRef,
                allChallengeRef
            ) = createRefs()
            HomeHeader(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(headerRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })
            SavingCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(savingCardRef) {

                    }
            )
            CurrentChallenge(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(currentChallengeRef) {
                    top.linkTo(savingCardRef.bottom)
                    start.linkTo(parent.start)
                }
                .offset(y = 300.dp)
                .padding(horizontal = 24.dp))
            AllChallenge(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(allChallengeRef) {
                    start.linkTo(parent.start)
                    top.linkTo(currentChallengeRef.bottom)
                }
                .padding(horizontal = 24.dp)
                .offset(y = 300.dp)
            )
        }
    }

}

@Composable
fun HomeHeader(modifier: Modifier) {
//    val userLevel = viewModel.userLevel.toString()
//    val userName = viewModel.userName
//    val userColor = viewModel.userBgColor

    Box(modifier = modifier) {
        Card(
            backgroundColor = PiggyRichColor.Chicken,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp)
        ) {
            Column(modifier = Modifier.padding(bottom = 200.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Go to Badge Screen",
                    )
                    Text(text = "Level 1", style = PiggyPigTypography.h3, color = Color.White)
                }
                Text(
                    text = "แม่มดน้อยโดเรมี",
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
fun SavingCard(modifier: Modifier) {
//    val userMascot = viewModel.userMascot
//    val userSavingAmount = viewModel.savingAmount.toString()
    // TODO user color for saving text

    Box(modifier = modifier) {
        Card(
            modifier
                .wrapContentSize()
                .padding(bottom = 32.dp, start = 32.dp, end = 32.dp)
                .offset(y = 300.dp),
            shape = Shapes.medium
        ) {
            Column(Modifier.padding(32.dp)) {
                Text(
                    text = stringResource(id = R.string.home_your_current_saving_text),
                    style = PiggyPigTypography.h2,
                    color = PiggyRichColor.Gray818181,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "30,000", style = PiggyPigTypography.h1,
                    color = PiggyRichColor.Chicken,
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
            painter = painterResource(id = R.drawable.char_chicken),
            contentDescription = "User Animal Mascot",
            modifier = modifier
                .offset(y = 170.dp)
                .size(150.dp)
        )
    }
}

@Composable
fun CurrentChallenge(modifier: Modifier) {
//    val userCurrentChallenge = viewModel.userLevel

    Box(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.home_current_challenge),
            style = PiggyPigTypography.h3,
            color = PiggyRichColor.Gray818181
        )
//        LazyColumn() {
//            // TODO Handle to show current challenge
//        }
    }
}

@Composable
fun AllChallenge(modifier: Modifier) {
    Box(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.home_all_challenge),
            style = PiggyPigTypography.h3,
            color = PiggyRichColor.Gray818181
        )
//        LazyColumn() {
//            // TODO Handle to show current challenge
//        }
    }
}

@Preview(showBackground = true, locale = "th")
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}