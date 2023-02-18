package com.natersfantasy.piggyrichrpg.scence.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigColor
import com.natersfantasy.piggyrichrpg.ui.theme.PoppinsFontFamily

@Composable
internal fun SplashScreen() {
    // TODO Make animation
    Column(modifier = Modifier.fillMaxSize()) {
        AppBottomWithMascot()
    }

}

@Composable
private fun AppBottomWithMascot() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(modifier = Modifier.padding(bottom = 600.dp)) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = PiggyPigColor.GiraffeYellowText
            )
        }
        Image(
            painter = painterResource(id = R.drawable.spashscreenwave),
            contentDescription = "splashscreen",
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
            // TODO change png mascot to svg later if I have svg file
            Image(
                painter = painterResource(id = R.drawable.char_giraffe),
                contentDescription = "GiraffeMascot",
                modifier = Modifier.size(500.dp).offset(x = 120.dp, y = 55.dp)
            )
        }
    }


}

@Preview(showBackground = true, locale = "th")
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}