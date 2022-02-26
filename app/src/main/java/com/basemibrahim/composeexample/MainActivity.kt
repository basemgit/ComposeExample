package com.basemibrahim.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.basemibrahim.composeexample.navigation.SetupNavGraph
import com.basemibrahim.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
               val navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}


