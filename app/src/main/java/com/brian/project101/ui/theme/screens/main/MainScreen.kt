package com.brian.project101.ui.theme.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.brian.project101.R
import com.brian.project101.navigation.ROUTE_APPLICATION
import com.brian.project101.navigation.ROUTE_CALL
import com.brian.project101.ui.theme.screens.cards.CardTeachers
import com.brian.project101.ui.theme.screens.cards.InstituteCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row() {
            Column {
                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 70.dp),
                    text = "Good evening!",
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 32.sp,
                    color = Color.Black,
                )
                Text(
                    modifier = Modifier.padding(start = 21.dp),
                    text = "Brian Ouma",
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )}
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "profile image",
                modifier = Modifier
                    .padding(top = 30.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ){}
                    .size(65.dp)
                    .clip(shape = RoundedCornerShape(14.dp))
                    .border(7.dp, Color.White, RoundedCornerShape(14.dp))
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .padding(top = 5.dp, start = 20.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(corner = CornerSize(12.dp))
                    ),
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text(
                        text = "Call for More Information",
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                },
                colors =
                TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                singleLine = true,
                trailingIcon = {
                    Button(
                        onClick = {
                            navController.navigate(ROUTE_CALL)
                        },
                        colors = ButtonDefaults.buttonColors(),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        shape =
                        RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp,
                            bottomStart = 12.dp,
                            bottomEnd = 12.dp
                        )
                    ) {
                        Icon(
                            Icons.Filled.Call,
                            contentDescription = "Search",
                            modifier = Modifier.size(30.dp),
                            tint = Color.White
                        )
                    }
                }
            )
            Icon(
                painter = painterResource(id = R.drawable.f),
                contentDescription = "customization",
                tint = Color.Black,
                modifier =
                Modifier
                    .size(38.dp)
                    .padding(start = 5.dp)
                    .weight(1f)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        /*TODO*/
                    }
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Row() {
            Text(
                text = "Popular Teachers",
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .weight(5f)
            )
            Image(
                painter = painterResource(id = R.drawable.f),
                contentDescription = "filter",
                modifier = Modifier
                    .size(30.dp)
                    .weight(2f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.width(20.dp))
            CardTeachers(
                title = "Cassie Valdez",
                subject = "Biology",
                backgroundColor = DefaultTintColor,
                image = R.drawable.firstperson,
                modifier =
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {}
            )
            Spacer(modifier = Modifier.width(20.dp))
            CardTeachers(
                title = "Paul Simons",
                subject = "Chemistry",
                backgroundColor = DefaultTintColor,
                image = R.drawable.secondperson,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {}
            )
            Spacer(modifier = Modifier.width(20.dp))
            CardTeachers(
                title = "Graham Osbor",
                subject = "Physics",
                backgroundColor = DefaultTintColor,
                image = R.drawable.thirdperson,
                modifier =
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {}
            )
            Spacer(modifier = Modifier.width(20.dp))
            CardTeachers(
                title = "Veer Cope",
                subject = "Bio Science",
                backgroundColor = DefaultTintColor,
                image = R.drawable.fourthperson,
                modifier =
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {}
            )
            Spacer(modifier = Modifier.width(20.dp))
        }

        Spacer(modifier = Modifier.height(40.dp))
        Row() {
            Text(
                text = "Popular Institution",
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .weight(5f)
            )
            Image(
                painter = painterResource(id = R.drawable.f),
                contentDescription = "filter",
                modifier = Modifier
                    .size(30.dp)
                    .weight(2f)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
            InstituteCard(
                modifier =
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    navController.navigate(ROUTE_APPLICATION)
                },
                collegeName = "Victory College",
                rating = "4.5",
                reviews = "413",
                subject = "Bio Science",
                description =
                "Studying how CBD awareness and availability as it related to pain management alternatives.",
                backgroundColor = DefaultShadowColor,
                image = R.drawable.vic
            )
            Spacer(modifier = Modifier.height(20.dp))
            InstituteCard(
                modifier =
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    navController.navigate(ROUTE_APPLICATION)
                },
                collegeName = "New Montana",
                rating = "4.1",
                reviews = "354",
                subject = "Bio Science",
                description = "Montana Higher Educational Institute. Gampaha montana.gampaha@gmail.com.",
                backgroundColor = DefaultShadowColor,
                image = R.drawable.mont
            )
            Spacer(modifier = Modifier.height(20.dp))
            InstituteCard(
                modifier =
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    navController.navigate(ROUTE_APPLICATION)
                },
                collegeName = "Susipwan Institute",
                rating = "3.0",
                reviews = "745",
                subject = "Bio Science",
                description =
                "This is a private higher education center which conducting classes for GCE ALL Students.",
                backgroundColor = DefaultShadowColor,
                image = R.drawable.ins
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}