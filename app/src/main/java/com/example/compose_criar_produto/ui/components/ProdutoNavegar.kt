package com.example.compose_criar_produto.ui.components

import androidx.compose.ui.text.font.Font
import com.example.compose_criar_produto.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

val InterFont = FontFamily(
    Font(R.font.inter_variablefont_opszwght, FontWeight.Normal),
    Font(R.font.inter_variablefont_opszwght, FontWeight.Medium),
    Font(R.font.inter_variablefont_opszwght, FontWeight.Bold)
)

@Composable
fun ProdutoNavegar (
    Imagem: Painter,
    Titulo: String,
    BreveDesc: String,
    Avaliacao: Double,
    Preco: Double
) {
    Row() {
        Image(
            painter = Imagem,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(130.dp, 100.dp)
        )
        Column() {
            Text(
                text = Titulo,
                fontFamily = InterFont,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = BreveDesc
            )
            Text(
                text = "$Avaliacao"
            )
            Text(
                text = "$Preco"
            )
        }
    }

}