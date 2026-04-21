package com.example.compose_criar_produto.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    containerColor: Color = Color.Gray,
    borderColor: Color = Color.Transparent,
    shape: Shape = CircleShape
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        border = BorderStroke(1.5.dp, borderColor),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = textColor,
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = textColor
        )
    }
}
