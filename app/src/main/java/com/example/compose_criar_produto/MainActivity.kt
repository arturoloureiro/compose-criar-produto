package com.example.compose_criar_produto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_criar_produto.ui.components.ButtonCustomized
import com.example.compose_criar_produto.ui.components.ButtonFilter
import com.example.compose_criar_produto.ui.components.ButtonMoreCustomizable
import com.example.compose_criar_produto.ui.components.Categorias
import com.example.compose_criar_produto.ui.theme.ComposecriarprodutoTheme
import com.example.compose_criar_produto.ui.components.CalculadoraCategoria
import com.example.compose_criar_produto.ui.components.FixedTextField
import com.example.compose_criar_produto.ui.components.Ordem
import com.example.compose_criar_produto.ui.components.OrderBy
import com.example.compose_criar_produto.ui.components.ProdutoNavegar
import com.example.compose_criar_produto.ui.components.SearchBar
import com.example.compose_criar_produto.ui.theme.BgDefault

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
fun Tela() {
    val libreCaslonDisplay = FontFamily(Font(R.font.librecaslondisplay_regular))
    val bgColor = colorResource(id = R.color.bgColor)
    val btColor = colorResource(id = R.color.bt_default)
    var textName by remember { mutableStateOf("") }
    var textDesc1 by remember { mutableStateOf("") }
    var textDesc2 by remember { mutableStateOf("") }
    var textPesquisarMu by remember { mutableStateOf("")}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.25f)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp, 70.dp)


        ) {
            var mostrarCategorias by remember { mutableStateOf(false) }
            Row(modifier = Modifier.fillMaxWidth() .height(40.dp)) {
                ButtonFilter(
                    text = "Filtros",
                    onClick = { mostrarCategorias = !mostrarCategorias }
                )
            }

            AnimatedVisibility(
                visible = ButtonFilter.statusCategoriasAbertas,
                enter = expandVertically(
                    expandFrom = Alignment.Top,
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(durationMillis = 300)),
                exit = shrinkVertically(
                    shrinkTowards = Alignment.Top,
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(durationMillis = 300))
            ) {
                Column (modifier = Modifier.background(bgColor)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text = "Ordenar por",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp).width(3.dp).background(btColor))
                        OrderBy()
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text = "Município",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp)
                                .background(bgColor)
                        )
                        Spacer(modifier = Modifier.height(20.dp).width(3.dp).background(btColor))
                        SearchBar(
                            modifier = Modifier.weight(1f),
                            text = textPesquisarMu,
                            textColor = Color.Black,
                            onTextChange = { textPesquisarMu = it },
                            containerColor = BgDefault,
                            placeholder = "Pesquise um município"
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Categorias",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Categorias(
                        categorias = listOf("Têxteis", "Cerâmica", "Entalhe"),
                    ) { categoria ->
                        val larguraDinamica by remember(categoria) {
                            mutableStateOf(CalculadoraCategoria.calcularLargura(categoria))
                        }
                        ButtonMoreCustomizable(
                            text = categoria,
                            textColor = btColor,
                            containerColor = bgColor,
                            borderColor = btColor,
                            widthButton = larguraDinamica,
                            heightButton = 40.0,
                            modifier = Modifier,
                            onClick = { println("Clicou em $categoria") }
                        )
                    }
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(50.dp)
                    .background(bgColor)

            ) {
                Text(
                    "Descubra",
                    Modifier.width(200.dp),
                    fontFamily = libreCaslonDisplay,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn {
                item {
                    ProdutoNavegar(
                        Imagem = painterResource(id = R.drawable.placeholder),
                        Titulo = "Capixabidade",
                        BreveDesc = "Trata-se do que é capixaba",
                        Avaliacao = 99999999999.0,
                        Preco = 99999999999.0
                    )
                }
            }

        }
    }
}

