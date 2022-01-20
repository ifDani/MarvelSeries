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



    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
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