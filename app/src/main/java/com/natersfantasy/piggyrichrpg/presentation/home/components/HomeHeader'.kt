package com.natersfantasy.piggyrichrpg.presentation.home.components

import android.content.res.Configuration
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
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.data.game.levelList
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigTypography
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme

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
fun HomeHeader_Preview() {
    PiggyRichRPGTheme() {
        HomeHeader(
            modifier = Modifier,
            userLevel = "1",
            userName = "ลำดวน",
            userColor = levelList[0].levelColor
        )
    }
}