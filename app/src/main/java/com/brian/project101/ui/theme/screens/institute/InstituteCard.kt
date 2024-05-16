package com.brian.project101.ui.theme.screens.institute

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brian.project101.R

@Composable
fun InstituteCard(
    modifier: Modifier,
    collegeName: String,
    rating: String,
    reviews: String,
    subject: String,
    description: String,
    backgroundColor: Color,
    image: Int,
) {
    Card(
        modifier = modifier.height(220.dp).fillMaxWidth().fillMaxSize().shadow(elevation = 8.dp, shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = modifier.padding(15.dp)) {
            Column(
                modifier = modifier.height(190.dp).width(160.dp).clip(shape = RoundedCornerShape(12.dp)).background(backgroundColor)
            ) {
                Image(
                    modifier = modifier.size(190.dp).padding(5.dp),
                    painter = painterResource(id = image),
                    contentDescription = "college_first"
                )
            }
            Column {
                Text(
                    text = collegeName,
                    fontSize = 18.sp,
                    modifier = modifier.padding(top = 7.dp, start = 7.dp),
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(start = 7.dp, top = 3.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.s),
                        contentDescription = "rating",
                        modifier = modifier.size(18.dp).padding(2.dp),
                        tint = Color.Green
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.s),
                        contentDescription = "rating",
                        modifier = modifier.size(18.dp).padding(2.dp),
                        tint = Color.Green
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.s),
                        contentDescription = "rating",
                        modifier = modifier.size(18.dp).padding(2.dp),
                        tint = Color.Green
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.s),
                        contentDescription = "rating",
                        modifier = modifier.size(18.dp).padding(2.dp),
                        tint = Color.Green
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.starr),
                        contentDescription = "rating",
                        modifier = modifier.size(18.dp).padding(2.dp),
                        tint = Color.Green
                    )
                    Text(
                        text = "$rating ($reviews)",
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray
                    )
                }
                Column(modifier = modifier.padding(start = 10.dp, top = 2.dp)) {
                    Text(
                        text = subject,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Text(
                        text = description,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        maxLines = 10,
                        lineHeight = 15.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun InstituteCardPreview() {
   
}