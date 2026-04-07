import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpandingTextField(
    text: String,
    onTextChange: (String) -> Unit,
    placeholder: String
) {
    val bgColor = MaterialTheme.colorScheme.background
    BasicTextField(
        value = text,
        onValueChange = onTextChange,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        ),
        minLines = 1,
        maxLines = Int.MAX_VALUE,
        modifier = Modifier
            .width(348.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor)
            .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(12.dp),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart
            ) {
                if (text.isEmpty()) {
                    Text(
                        text = placeholder,
                        fontSize = 18.sp,
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        }
    )
}