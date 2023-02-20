package com.natersfantasy.piggyrichrpg.presentation.splashscreen

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.presentation.splashscreen.viewmodel.SplashScreenEvent
import com.natersfantasy.piggyrichrpg.presentation.splashscreen.viewmodel.SplashScreenViewModel
import com.natersfantasy.piggyrichrpg.ui.theme.MitrFontFamily
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.util.UiEvent
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen(
    onPopBackStack: () -> Unit,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: SplashScreenViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    // TODO Make animation
    LaunchedEffect(key1 = true) {
        delay(3000)
        viewModel.onEvent(SplashScreenEvent.OnSplashScreenRun)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            AppName()
            AppBottomWithMascot()
        }
    }
}

@ShowkaseComposable(name = "AppName", group = "SplashScreen")
@Composable
fun AppName() {
    Box(modifier = Modifier.padding(bottom = 600.dp)) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontFamily = MitrFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 60.sp,
            color = PiggyRichColor.GiraffeYellowText,
            letterSpacing = 1.sp
        )
    }
}

@ShowkaseComposable(name = "AppBottomWithMascot", group = "SplashScreen")
@Composable
fun AppBottomWithMascot() {
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

//@Preview(showBackground = true, locale = "th")
@Composable
fun SplashScreenPreview() {
    SplashScreen(onPopBackStack = {}, onNavigate = {},)
}