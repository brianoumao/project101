package com.brian.project101.ui.theme.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun WelcomeScreen(navController: NavHostController) {
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
                text = "Your Application has been submitted.We would like to ask you for patience as we take a look.W e would like to ask you to check your Email after two weeks.If we would have not got back to you maybe 1. you did not meet the expectations or 2. we never able to get your application.If your reason is the second  please go back to the Main screen and Call the office to know where the issue is. Thank you!",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )
            Text(
                modifier =
                Modifier.align(Alignment.CenterHorizontally).padding(top = 30.dp).clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                  navController.navigate(ROUTE_DETAILS)
                },
                text = "Go Back To Home Page",
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray
            )
        }
    }
}