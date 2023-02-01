package com.example.interview.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun screen1(goToScreen2: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 1")
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(onClick = goToScreen2) {
            Text("Go To Screen2")
        }
    }
}