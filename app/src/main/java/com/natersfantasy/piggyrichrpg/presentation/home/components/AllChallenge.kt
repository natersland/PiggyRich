package com.natersfantasy.piggyrichrpg.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme

@Composable
fun AllChallenge(modifier: Modifier) {
    Box(modifier = modifier) {

//        LazyColumn() {
//            // TODO Show all challenge with handle isActive status
//        }
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
fun AllChallenge_Preview() {
    PiggyRichRPGTheme() {

    }
}