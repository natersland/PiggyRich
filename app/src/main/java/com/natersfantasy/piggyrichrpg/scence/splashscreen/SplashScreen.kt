package com.natersfantasy.piggyrichrpg.scence.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.ui.theme.MitrFontFamily
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigColor
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen(navController: NavController) {
    // TODO Make animation
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate("UserDetail")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            AppName()
            AppBottomWithMascot()
        }
    }
}

@Composable
private fun AppName() {
    Box(modifier = Modifier.padding(bottom = 600.dp)) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontFamily = MitrFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 60.sp,
            color = PiggyPigColor.GiraffeYellowText,
            letterSpacing = 1.sp
        )
    }
}

@Composable
private fun AppBottomWithMascot() {
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
            modifier = Modifier
                .size(500.dp)
                .offset(x = 120.dp, y = 55.dp)
        )
    }
}

@Preview(showBackground = true, locale = "th")
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}