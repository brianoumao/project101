package com.brian.project101.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian.project101.ui.theme.screens.application.ApplicationScreen
import com.brian.project101.ui.theme.screens.call.Callscreen
import com.brian.project101.ui.theme.screens.main.MainScreen
import com.brian.project101.ui.theme.screens.home.HomeScreen
import com.brian.project101.ui.theme.screens.login.LoginScreen
import com.brian.project101.ui.theme.screens.register.RegisterScreen
import com.brian.project101.ui.theme.screens.splash.SplashScreen
import com.brian.project101.ui.theme.screens.welcome.WelcomeScreen

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
        composable(ROUTE_CALL){
            Callscreen(navController) }
        composable(ROUTE_WELCOME){
            WelcomeScreen(navController) }
        composable(ROUTE_APPLICATION){
            ApplicationScreen(navController) }
     }
}