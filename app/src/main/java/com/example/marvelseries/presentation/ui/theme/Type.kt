package com.example.marvelseries.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.marvelseries.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.White
    ),

)
val titleStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 34.sp,
    color = Color.White
)
val nameCharacter = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 24.sp,
    color = Color.White
)
val attrCharList = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 14.sp,
    color = Color.White
)


//Detail Styles
val nameHeroDetail = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 42.sp,
    color = Color.White
)
val sectionHeroTitle = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 26.sp,
    color = Color.White
)
fun descHeroDetail(color: Color = Color.White): TextStyle {
   return TextStyle(
        fontFamily = FontFamily(Font(R.font.marvel_bold)),
        fontSize = 18.sp,
        color = color
    )
}

//Comic Styles
val comicNameStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 38.sp,
    color = Color.White
)
val example = TextStyle(
    fontFamily = FontFamily(Font(R.font.marvel_bold)),
    fontSize = 14.sp,
    color = Color.Black
)