package com.natersfantasy.piggyrichrpg.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigTypography
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme
import com.natersfantasy.piggyrichrpg.ui.theme.h2
import com.natersfantasy.piggyrichrpg.util.addCommasToNumber

@Composable
internal fun ChallengeCard(
    savingGoal: String,
    mascotName: String,
    mascotImage: Int,
    challengeColor: Color,
    isUnlock: Boolean
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .wrapContentHeight(),
        backgroundColor = if (isUnlock) challengeColor else PiggyRichColor.Disable
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.padding(end = 24.dp)) {
                Text(
                    text = stringResource(id = R.string.level_kept_money, savingGoal),
                    style = PiggyPigTypography.h5,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                Text(
                    text = if (isUnlock) mascotName else "???",
                    style = PiggyPigTypography.h2,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Image(
                painter = painterResource(id = mascotImage),
                contentDescription = mascotName,
                modifier = Modifier
                    .size(120.dp)
                    .offset(y = 20.dp)
                    .padding(end = 4.dp),
                colorFilter = if (isUnlock) null else ColorFilter.tint(PiggyRichColor.Gray9D9D9D)
            )
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
fun ChallengeCard_Preview() {
    PiggyRichRPGTheme() {
        ChallengeCard(
            savingGoal = addCommasToNumber(5000),
            mascotName = "ไก่น้อย",
            mascotImage = R.drawable.char_chicken,
            challengeColor = PiggyRichColor.Chicken,
            isUnlock = true
        )
    }
}