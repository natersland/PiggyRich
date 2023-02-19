package com.natersfantasy.piggyrichrpg.presentation.newmember

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.commons.components.PiggyPigRoundedButton
import com.natersfantasy.piggyrichrpg.ui.theme.*
import com.natersfantasy.piggyrichrpg.util.UiEvent

@Composable
internal fun NewMemberScreen(
    onPopBackStack: () -> Unit,
    viewModel: NewMemberViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                else -> Unit
            }
        }
    }

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
            UserDetailForm(viewModel)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            AppBottomWave()
            TextButton(
                onClick = { viewModel.onEvent(NewMemberEvent.OnStartClick) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 32.dp, bottom = 32.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.new_member_next_button),
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
private fun UserDetailForm(viewModel: NewMemberViewModel) {
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
                text = stringResource(id = R.string.new_member_myname),
                style = PiggyPigTypography.h1,
                color = PiggyPigColor.GiraffeYellowText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            FormTextField(viewModel)
            PiggyPigRoundedButton(
                onClick = { viewModel.onEvent(NewMemberEvent.OnRandomClick) },
                text = stringResource(id = R.string.new_member_random),
                btnColor = PiggyPigColor.Lobster,
                enabled = true,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
private fun FormTextField(viewModel: NewMemberViewModel) {
    val context = LocalContext.current
    val maxChar = 15
    val userNameLength = viewModel.userName.length

    OutlinedTextField(
        value = viewModel.userName,
        onValueChange = { inputName ->
            if (inputName.length <= maxChar) {
                viewModel.onEvent(NewMemberEvent.OnUserNameChange(inputName))
            } else {
                Toast.makeText(context, R.string.new_member_char_limit, Toast.LENGTH_LONG).show()
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
            id = R.string.new_member_char_counter,
            userNameLength.toString(),
            maxChar.toString()
        ), style = PiggyPigTypography.body1, color = when (userNameLength) {
            in 7..14 -> PiggyPigColor.Lobster
            15 -> Color.Red
            else -> PiggyPigColor.Gray818181
        }
    )
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
fun NewMemberScreenPreview() {

}