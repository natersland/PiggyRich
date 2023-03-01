package com.natersfantasy.piggyrichrpg.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.data.game.levelList
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigTypography
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme
import com.natersfantasy.piggyrichrpg.ui.theme.Shapes
import com.natersfantasy.piggyrichrpg.util.addCommasToNumber

@Composable
fun SavingCard(
    modifier: Modifier,
    userColor: Color,
    userMascot: Int,
    savingAmount: Int
) {
    val formattedSavingAmount = addCommasToNumber(savingAmount)

    Box(modifier = modifier) {
        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = userMascot),
                    contentDescription = "User Animal Mascot",
                    modifier = modifier
                        .size(150.dp)
                        .align(Alignment.Center)
                )
            }
            Card(
                modifier
                    .wrapContentSize(),
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
        }
    }
}

@Preview(name = "th_light", showBackground = true, locale = "th")
@Preview(name = "en_light", showBackground = true, locale = "en")
@Preview(
    name = "th_dark",
    showBackground = true,
    locale = "th",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(name = "th_large_font", showBackground = true, locale = "th", fontScale = 1.5f)
@Composable
fun SavingCard_Preview() {
    PiggyRichRPGTheme() {
        SavingCard(
            modifier = Modifier,
            userColor = PiggyRichColor.Chicken,
            userMascot = levelList[0].mascotImage,
            savingAmount = 60000
        )

    }
}