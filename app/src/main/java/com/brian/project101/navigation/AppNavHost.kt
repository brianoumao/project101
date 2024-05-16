package com.brian.project101.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.project101.ui.theme.screens.main.MainScreen
import com.brian.project101.ui.theme.screens.home.HomeScreen
import com.brian.project101.ui.theme.screens.institute.InstituteCard
import com.brian.project101.ui.theme.screens.intent.Intentscreen
import com.brian.project101.ui.theme.screens.login.LoginScreen
import com.brian.project101.ui.theme.screens.gape.GapeScreen
import com.brian.project101.ui.theme.screens.register.RegisterScreen
import com.brian.project101.ui.theme.screens.splash.SplashScreen
import com.brian.project101.ui.theme.screens.teacher.CardTeachers

@Composable
fun AppNavHost(modifier: Modifier =Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String= ROUTE_SPLASH){
    NavHost(navController = navController,
        startDestination= startDestination,
        modifier = modifier) {
        composable(ROUTE_SPLASH) {
             SplashScreen(navController) }
        composable(ROUTE_LOGIN){
             LoginScreen(navController) }
        composable(ROUTE_REGISTER){
             RegisterScreen(navController) }
        composable(ROUTE_HOME){
             HomeScreen(navController) }
        composable(ROUTE_DETAILS){
             MainScreen(navController) }
        composable(ROUTE_GAPE){
             GapeScreen(navController) }
        composable (ROUTE_INTENT){
             Intentscreen(navController) }
        composable(ROUTE_STUDENT){
             InstituteCard(
                 modifier ,
                 collegeName = String.toString(),
                 rating = String.toString(),
                 reviews = String.toString(),
                 subject = String.toString(),
                 description = String.toString(),
                 backgroundColor = (MaterialTheme.colorScheme.background),
                 image = hashCode()
             )}
        composable(ROUTE_TEACHER) {
             CardTeachers(
                 modifier,
                 title = String.toString(),
                 subject = String.toString(),
                 backgroundColor= (MaterialTheme.colorScheme.background),
                 image = hashCode()
             ) }
    }
}