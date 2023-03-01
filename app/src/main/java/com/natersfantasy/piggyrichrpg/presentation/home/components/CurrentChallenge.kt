package com.natersfantasy.piggyrichrpg.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.data.game.Level
import com.natersfantasy.piggyrichrpg.data.game.levelList
import com.natersfantasy.piggyrichrpg.presentation.home.HomeScreenViewState
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigTypography
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme
import com.natersfantasy.piggyrichrpg.util.addCommasToNumber

@Composable
fun CurrentChallenge(modifier: Modifier, currentChallenge: Level?) {
    val savingGoal = currentChallenge?.savingGoal
    val mascotName = currentChallenge?.mascotName
    val mascotImage = currentChallenge?.mascotImage
    val challengeColor = currentChallenge?.levelColor

    Column(modifier = modifier.fillMaxWidth()) {
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
fun CurrentChallenge_Preview() {
    val level1 = levelList[0]
    PiggyRichRPGTheme {
        CurrentChallenge(
            modifier = Modifier,
            currentChallenge = Level(
                level = level1.level,
                savingGoal = level1.savingGoal,
                mascotName = level1.mascotName,
                mascotImage = level1.mascotImage,
                levelColor = level1.levelColor
            )
        )

    }
}

