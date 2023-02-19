package com.natersfantasy.piggyrichrpg.commons.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyPigColor
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichRPGTheme

@Composable
fun PiggyPigRoundedButton(
    onClick: () -> Unit,
    text: String,
    btnColor: Color,
    enabled: Boolean,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        enabled = enabled,
        modifier = modifier,
        contentPadding = PaddingValues(4.dp), // set padding in button
        colors = ButtonDefaults.buttonColors(backgroundColor = btnColor)
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 18.dp, vertical = 4.dp),
            textAlign = TextAlign.Center,
            color = when(btnColor) {
                Color.White -> PiggyPigColor.Gray818181
                else -> Color.White
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}


@Composable
@Preview
fun RoundedButtonPreview() {
    PiggyRichRPGTheme() {
        PiggyPigRoundedButton(
            onClick = {},
            text = stringResource(id = R.string.user_result_start),
            btnColor = PiggyPigColor.Lobster,
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

enum class ButtonTextSize {
    MidLarge
}