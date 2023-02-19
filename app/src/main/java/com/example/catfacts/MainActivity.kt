package com.example.catfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.catfacts.presentation.list.components.ListView
import com.example.catfacts.presentation.specific.components.SpecificView
import com.example.catfacts.ui.theme.CatfactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatfactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navig()
                }
            }
        }
    }
}

@Composable
fun Navig(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable("main"){
            ListView(navController = navController)
        }
        composable("specific/{id}")
        {
            SpecificView()
        }
    }
}