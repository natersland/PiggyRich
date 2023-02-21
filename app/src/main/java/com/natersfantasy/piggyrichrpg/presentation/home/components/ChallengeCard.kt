package com.natersfantasy.piggyrichrpg.presentation.home.components

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

    val contrast = 2f // 0f..10f (1 should be default)
    val brightness = -180f // -255f..255f (0 should be default)
    val colorMatrix = floatArrayOf(
        contrast, 0f, 0f, 0f, brightness,
        0f, contrast, 0f, 0f, brightness,
        0f, 0f, contrast, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )

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

@Preview(showBackground = true, locale = "th")
@Composable
fun ChallengeCardPreview() {
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