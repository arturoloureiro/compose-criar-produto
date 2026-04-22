package com.example.compose_criar_produto.ui.components

import androidx.compose.ui.text.font.Font
import com.example.compose_criar_produto.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_criar_produto.ui.theme.bgDefault
import com.example.compose_criar_produto.ui.theme.btColor


@OptIn(ExperimentalTextApi::class)
val interFont = FontFamily(
    Font(
        R.font.inter_variablefont_opszwght,
        weight = FontWeight.Light,
        variationSettings = FontVariation.Settings(FontVariation.weight(300))
    ),
    Font(
        R.font.inter_variablefont_opszwght,
        weight = FontWeight.Normal,
        variationSettings = FontVariation.Settings(FontVariation.weight(400))
    ),
    Font(
        R.font.inter_variablefont_opszwght,
        weight = FontWeight.Medium,
        variationSettings = FontVariation.Settings(FontVariation.weight(500))
    ),
    Font(
        R.font.inter_variablefont_opszwght,
        weight = FontWeight.Bold,
        variationSettings = FontVariation.Settings(FontVariation.weight(700))
    )
)

@Composable

fun ProdutoNavegar (
    imagem: Painter,
    titulo: String,
    breveDesc: String,
    avaliacao: Double,
    preco: Double
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Row(modifier =  Modifier.fillMaxWidth().padding(top = 12.dp).background(bgDefault).padding(12.dp)) {
        Image(
            painter = imagem,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(screenWidth * 0.45f)
                .weight(1f)
                .padding(end = 12.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = titulo,
                fontSize = 20.sp,
                fontFamily = interFont,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 6.dp)

            )
            Text(
                text = breveDesc,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.estrelas),
                contentDescription = null,
                modifier = Modifier
                    .width(screenWidth * 0.2f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.Top){
                Text("R$ ", fontSize = 12.sp)
                Text(
                    text = "$preco",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(",00", fontSize = 12.sp)
            }
            AppButton(
                text ="Adicionar ao carrinho",
                fontSize = 16.sp,
                textColor = bgDefault,
                containerColor = btColor,
                borderColor = btColor,
                onClick = { println("Clicou em $screenWidth") },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(screenWidth * 0.5f)
                    .height(30.dp)
            )

        }
    }

}
