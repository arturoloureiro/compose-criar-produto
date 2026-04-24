package com.example.compose_criar_produto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.example.compose_criar_produto.R
import kotlin.math.absoluteValue

@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    val imageList = listOf(
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
    )

    val pagerState = rememberPagerState { imageList.size }

    Column(
        modifier
            .defaultMinSize(minHeight = screenWidth * 0.6f)
            .fillMaxWidth()
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            pageSpacing = 10.dp,
            contentPadding = PaddingValues(horizontal = 30.dp)
        ) { page ->

            val pageOffset = (pagerState.currentPage - page + pagerState.currentPageOffsetFraction)
                .absoluteValue
                .coerceIn(0f, 1f)

            val itemHeight = lerp(
                start = screenWidth * 0.6f,          // menor quando fora de foco
                stop  = screenWidth * 0.8f,  // maior quando centralizado
                fraction = 1f - pageOffset
            )

            Image(
                painter = painterResource(id = imageList[page]),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(itemHeight),
                contentScale = ContentScale.Crop
            )
        }

    }

}