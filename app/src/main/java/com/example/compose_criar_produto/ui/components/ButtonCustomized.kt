package com.example.compose_criar_produto.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ButtonCustomized(
    text: String,
    textColor: Color,
    containerColor: Color,
    borderColor: Color
){
    Button(
        onClick = { onClick(

        ) },
        modifier = Modifier
            .heightIn(50.dp)
            .width(198.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(2.dp, borderColor, RoundedCornerShape(50.dp)),
        //shape = RoundedCornerShape(9.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = textColor,
    )
    ){
        Text(
            text = text,
            fontSize = 18.sp,
            color = textColor
        )
    }
}

fun onClick() {
    TODO("Not yet implemented")
}
