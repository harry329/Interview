package com.example.interview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interview.screen.screen1
import com.example.interview.screen.screen2

@Composable
fun navigationGraph(navHostController: NavHostController = rememberNavController()) {

    NavHost(navController = navHostController, "Screen1") {
        composable("Screen1") {
            screen1(goToScreen2 = {navHostController.navigate("Screen2")})
        }
        composable("Screen2") {
            screen2(goToScreen1 = {navHostController.navigate("Screen1")})
        }
    }
}