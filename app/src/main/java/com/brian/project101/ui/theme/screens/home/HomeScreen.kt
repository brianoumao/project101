package com.brian.project101.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.brian.project101.R
import com.brian.project101.navigation.ROUTE_DETAILS

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(painter = painterResource(id = R.drawable.ic), contentDescription = "Image")
        Column(
            modifier = Modifier.padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Let's find the \"A\" with us",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Text(
                text = "Please Continue to view personalized recommendations",
                fontFamily = FontFamily.Cursive,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }

        Column(modifier = Modifier.padding(top = 30.dp).align(Alignment.CenterHorizontally)) {
            Button(
                onClick = {
                    navController.navigate(ROUTE_DETAILS)
                },
                colors = ButtonDefaults.buttonColors(),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(267.dp, 61.dp).align(Alignment.CenterHorizontally),
                enabled = true
            ) {
                Text(
                    text = "Go to Home",
                    color = Color.White,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal
                )
            }
            Text(
                    modifier =
                    Modifier.align(Alignment.CenterHorizontally).padding(top = 30.dp).clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {},
                    text = "Welcome",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray
                )
            }
        }
    }

