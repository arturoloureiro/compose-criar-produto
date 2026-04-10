package com.example.compose_criar_produto

import ExpandingTextField
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_criar_produto.ui.components.ButtonCustomized
import com.example.compose_criar_produto.ui.components.FixedTextField
import com.example.compose_criar_produto.ui.theme.BgDefault
import com.example.compose_criar_produto.ui.theme.ComposecriarprodutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposecriarprodutoTheme {
                Tela()

            }
        }
    }
}

@Composable
@Preview
fun Tela(){
    val libreCaslonDisplay = FontFamily(Font(R.font.librecaslondisplay_regular))
    val bgColor = colorResource(id = R.color.bgColor)
    val btColor = colorResource(id = R.color.bt_default)
    var textName by remember { mutableStateOf("") }
    var textDesc1 by remember { mutableStateOf("") }
    var textDesc2 by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background_image),
                contentScale = ContentScale.Crop,
                alpha = 0.25f
            ).padding(2.dp, 70.dp)

    ) {
        Text(
            "Adicionar Produto",
            Modifier.width(200.dp),
            fontFamily = libreCaslonDisplay,
            fontSize = 50.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(800.dp)
                .fillMaxWidth(1f)
                .background(bgColor)
                .verticalScroll(scrollState)
        ) {
                Box(
                    modifier = Modifier
                        .height(284.dp)
                        .width(348.dp)
                        .paint(
                            painterResource(id = R.drawable.placeholder),
                            contentScale = ContentScale.Crop
                        ),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonCustomized(
                            "escolher imagem",
                            Color.Black,
                            BgDefault,
                            Color.Black
                        )
                    }
                }

            Spacer(Modifier.height(20.dp))
            FixedTextField(
                text = textName,
                textColor = bgColor,
                onTextChange = { textName = it },
                placeholder = "Nome",
                containerColor = btColor,
                borderColor = btColor
            )
            Spacer(Modifier.height(20.dp))
            ExpandingTextField(
                text = textDesc1,
                textColor = Color.Black,
                onTextChange = { textDesc1 = it },
                placeholder = "Descrição",
                containerColor = bgColor,
                borderColor = btColor
            )
            Spacer(Modifier.height(20.dp))
            ExpandingTextField(
                text = textDesc2,
                textColor = Color.Black,
                onTextChange = { textDesc2 = it },
                placeholder = "Descrição adicional (opicional)",
                containerColor = bgColor,
                borderColor = btColor
            )
            Spacer(Modifier.height(20.dp))
            ButtonCustomized(
                text = "Adicionar",
                textColor = bgColor,
                containerColor = btColor,
                borderColor = btColor
                )
        }

    }
}

