package com.natersfantasy.piggyrichrpg.ui.theme

import android.content.res.Resources
import androidx.compose.material.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.natersfantasy.piggyrichrpg.R
import java.util.*

@OptIn(ExperimentalTextApi::class)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

@OptIn(ExperimentalTextApi::class)
val MitrFont = GoogleFont(name = "Mitr")

@OptIn(ExperimentalTextApi::class)
val PoppinsFont = GoogleFont(name = "Poppins")

// English Font
//@OptIn(ExperimentalTextApi::class)
//val PoppinsFontFamily = FontFamily(
//    Font(PoppinsFont, fontProvider = provider),
//    androidx.compose.ui.text.font.Font(resId = R.font.poppins_regular),
//    Font(PoppinsFont, fontProvider = provider, weight = FontWeight.Medium),
//    androidx.compose.ui.text.font.Font(resId = R.font.poppins_medium, weight = FontWeight.Medium),
//    Font(PoppinsFont, fontProvider = provider, weight = FontWeight.SemiBold),
//    androidx.compose.ui.text.font.Font(
//        resId = R.font.poppins_semibold,
//        weight = FontWeight.SemiBold
//    ),
//    Font(PoppinsFont, fontProvider = provider, weight = FontWeight.Bold),
//    androidx.compose.ui.text.font.Font(resId = R.font.poppins_bold, weight = FontWeight.Bold),
//)

// Thai Font
@OptIn(ExperimentalTextApi::class)
val MitrFontFamily = FontFamily(
    Font(MitrFont, fontProvider = provider),
    androidx.compose.ui.text.font.Font(resId = R.font.mitr_regular),
    Font(MitrFont, fontProvider = provider, weight = FontWeight.Medium),
    androidx.compose.ui.text.font.Font(resId = R.font.mitr_medium, weight = FontWeight.Medium),
    Font(MitrFont, fontProvider = provider, weight = FontWeight.SemiBold),
    androidx.compose.ui.text.font.Font(resId = R.font.mitr_semibold, weight = FontWeight.SemiBold),
    Font(MitrFont, fontProvider = provider, weight = FontWeight.Bold),
    androidx.compose.ui.text.font.Font(resId = R.font.mitr_semibold, weight = FontWeight.Bold),
)
val userLanguage = Resources.getSystem().getConfiguration().locale.displayLanguage;

val PiggyPigTypography = Typography(
    body1 = TextStyle(
        fontFamily = MitrFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 1.sp
    ),
    button = TextStyle(
        fontFamily = MitrFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        letterSpacing = 1.sp
    ),
    h1 = TextStyle(
        fontFamily = MitrFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        letterSpacing = 1.sp
    ),
    h2 = TextStyle(
        fontFamily = MitrFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 25.sp,
        letterSpacing = 1.sp
    ),
    h3 = TextStyle(
        fontFamily = MitrFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        letterSpacing = 1.sp
    ),
    h4 = TextStyle(
        fontFamily = MitrFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 1.sp
    ),
)