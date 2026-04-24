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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition.Center
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_criar_produto.ui.components.AppButton
import com.example.compose_criar_produto.ui.components.Categorias
import com.example.compose_criar_produto.ui.components.ImageCarousel
import com.example.compose_criar_produto.ui.theme.ComposecriarprodutoTheme
import com.example.compose_criar_produto.ui.components.OrderBy
import com.example.compose_criar_produto.ui.components.ProdutoNavegar
import com.example.compose_criar_produto.ui.components.SearchBar
import com.example.compose_criar_produto.ui.theme.bgDefault

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
    val cardColor = Color(0xFFFDF5E6)
    val btColor = colorResource(id = R.color.bt_default)
    var textPesquisarMu by remember { mutableStateOf("") }
    var mostrarCategorias by remember { mutableStateOf(false) }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
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
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(20))
                .padding(top = 20.dp)
                .background(bgColor)
                .padding(top = 20.dp),
            contentAlignment = Alignment.Center
        ){

        Box(
            modifier = Modifier
                .height(screenWidth * 0.4f)
                .width(screenWidth * 0.4f)
                .clip(RoundedCornerShape(50)) // tem que vir antes do background
                .background(btColor),
        )
            Spacer(modifier = Modifier.height(screenWidth * 0.35f))

                Row(
                    modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Paneleiras Capixabas",
                        fontSize = 40.sp,
                        fontFamily = libreCaslonDisplay
                    )
                }
                Row(
                    modifier = Modifier.wrapContentHeight().fillMaxWidth()
                        .padding(top = 10.dp, start = 8.dp, bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Nossos produtos",
                        fontSize = 20.sp,
                    )
                }
                ImageCarousel()
            }

        }
    }
}