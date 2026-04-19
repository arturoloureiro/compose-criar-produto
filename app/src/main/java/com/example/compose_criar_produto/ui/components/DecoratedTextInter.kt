package com.example.compose_criar_produto.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.compose_criar_produto.R

@Composable
fun DecoratedText (
    texto: String,
    fontSize: Double
){
    Text(
        text = texto,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Center
    )
}