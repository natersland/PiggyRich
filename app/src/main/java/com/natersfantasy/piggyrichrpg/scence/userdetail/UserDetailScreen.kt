package com.natersfantasy.piggyrichrpg.scence.userdetail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.commons.components.PiggyPigRoundedButton
import com.natersfantasy.piggyrichrpg.scence.userdetail.data.Name
import com.natersfantasy.piggyrichrpg.scence.userdetail.data.nameList
import com.natersfantasy.piggyrichrpg.ui.theme.*
import kotlin.random.Random

@Composable
internal fun UserDetailScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, bottom = 300.dp)
                .align(Alignment.Center)
        ) {
//            AboutMeText()
            UserDetailForm()
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            AppBottomWave()
            TextButton(
                onClick = { navController.navigate("Home") },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 32.dp, bottom = 32.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.user_detail_next_button),
                    style = PiggyPigTypography.h2,
                    color = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = "NextArrow"
                )
            }
        }
    }
}

@Composable
private fun UserDetailForm() {
    val (userName, setUsername) = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.user_detail_myname),
                style = PiggyPigTypography.h1,
                color = PiggyPigColor.GiraffeYellowText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            FormTextField(userName, setUsername)
            PiggyPigRoundedButton(
                onClick = { clickRandom(setUsername) },
                text = stringResource(id = R.string.user_detail_random),
                btnColor = PiggyPigColor.Lobster,
                enabled = true,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
private fun FormTextField(userName: String, setUsername: (String) -> Unit) {
    val context = LocalContext.current
    val maxChar = 15

    OutlinedTextField(
        value = userName,
        onValueChange = { inputName ->
            if (inputName.length <= maxChar) {
                setUsername(inputName)
            } else {
                Toast.makeText(context, R.string.user_detail_char_limit, Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = Shapes.small,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White,
            focusedBorderColor = PiggyPigColor.GrayE5E5E5,
            unfocusedBorderColor = PiggyPigColor.GrayE5E5E5,
            textColor = PiggyPigColor.Gray818181
        ),
        textStyle = PiggyPigTypography.h3,
        singleLine = true,
    )
    Text(
        text = stringResource(
            id = R.string.user_detail_char_counter,
            userName.length.toString(),
            maxChar.toString()
        ), style = PiggyPigTypography.body1, color = when(userName.length){
            in 7..14 -> PiggyPigColor.Lobster
            15 -> Color.Red
            else -> PiggyPigColor.Gray818181
        })
}

private fun generateRandomName(nameList: List<Name>): String {
    val random = Random.Default
    val randomIndex = random.nextInt(nameList.size)
    return when (userDisplayLanguage.language) {
        "th" -> nameList[randomIndex].thaiName
        else -> nameList[randomIndex].engName
    }
}

private fun clickRandom(setUsername: (String) -> Unit) {
    val result = generateRandomName(nameList = nameList)
    setUsername(result)
}

@Composable
private fun AppBottomWave() {
    Image(
        painter = painterResource(id = R.drawable.formwave),
        contentDescription = "formwave",
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true, locale = "th")
@Composable
fun SplashScreenPreview() {
    PiggyRichRPGTheme() {
        UserDetailScreen(rememberNavController())
    }
}